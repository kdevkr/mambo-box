# AWS Systems Manager Parameter Store

일반 설정 값 및 KMS 암호화 값(`SecureString`)을 계층 경로 기반으로 관리하는 서비스

- [AWS Systems Manager Parameter Store Documentation](https://docs.aws.amazon.com/systems-manager/latest/userguide/systems-manager-parameter-store.html)

## 특징

- 값을 파라미터 단위로 개별 관리 (계층 경로 `/app/env/key` 패턴 활용 가능)
- 기본(Standard) 티어 무료 사용 가능 (사용자 관리 KMS 키 등 별도 리소스 비용은 별개)
- 자체 자동 회전(Rotation) 기능 미지원

## IAM 권한 설정

조회 방식과 주체에 따라 권한 및 대상 IAM 역할 구분 필요

- **EC2**: 인스턴스 프로파일 역할(EC2 역할)
- **ECS (런타임 직접 조회)**: 컨테이너 내부에서 직접 AWS API 호출 시 태스크 역할(`taskRoleArn`)
- **ECS (`secrets.valueFrom` 주입)**: 컨테이너 시작 시 ECS가 환경 변수로 주입할 때 태스크 실행 역할(`executionRoleArn`)

```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": [
        "ssm:GetParameter",
        "ssm:GetParameters",
        "ssm:GetParametersByPath"
      ],
      "Resource": [
        "arn:aws:ssm:ap-northeast-2:123456789012:parameter/myapp/prod",
        "arn:aws:ssm:ap-northeast-2:123456789012:parameter/myapp/prod/*"
      ]
    },
    {
      "Effect": "Allow",
      "Action": "kms:Decrypt",
      "Resource": "arn:aws:kms:ap-northeast-2:123456789012:key/<kms-key-id>"
    }
  ]
}
```

- `Resource`는 `*` 대신 필요한 파라미터 경로 패턴으로 최소 권한 제한 권장
- `ssm:GetParametersByPath`를 끝 슬래시 없이(`--path /myapp/prod`) 호출할 때 `AccessDeniedException`을 피하려면 `parameter/myapp/prod`와 `parameter/myapp/prod/*`를 함께 명시
- 기본 키(`aws/ssm`) 사용 시 `kms:Decrypt` Statement 생략 가능
- 사용자 관리 KMS 키(CMK)로 암호화한 경우 IAM 정책의 `kms:Decrypt` 외에 해당 KMS 키 리소스 정책(Key Policy)에서도 역할 허용 필요

## EC2 환경 변수 주입

### 경로 패턴 일괄 조회

`/myapp/prod/` 경로 아래의 `SecureString` 파라미터를 한 번에 조회하여 환경 변수로 주입 (`ssm:GetParametersByPath` 권한 필요)

```bash
#!/usr/bin/env bash
set +x
set -euo pipefail

params="$(aws ssm get-parameters-by-path \
  --path /myapp/prod/ \
  --recursive \
  --with-decryption \
  --query 'Parameters[].{Name:Name,Value:Value}' \
  --output json)"

export SPRING_DATASOURCE_USERNAME="$(jq -er '.[] | select(.Name == "/myapp/prod/DB_USERNAME") | .Value' <<< "$params")"
export SPRING_DATASOURCE_PASSWORD="$(jq -er '.[] | select(.Name == "/myapp/prod/DB_PASSWORD") | .Value' <<< "$params")"
export APP_API_KEY="$(jq -er '.[] | select(.Name == "/myapp/prod/API_KEY") | .Value' <<< "$params")"

unset params
exec java -jar app.jar
```

### 단일 파라미터 조회

단일 `SecureString` 값만 필요한 경우 `aws ssm get-parameter` 사용 (`ssm:GetParameter` 권한 필요)

```bash
#!/usr/bin/env bash
set +x
set -euo pipefail

password="$(aws ssm get-parameter \
  --name /myapp/prod/smtp-password \
  --with-decryption \
  --query Parameter.Value \
  --output text)"

export SPRING_MAIL_PASSWORD="$password"
unset password
exec java -jar app.jar
```

- `set +x`: 상위 셸이나 CI/CD 환경의 디버그 추적 활성화 시 조회 값이 로그에 출력되는 현상 방지
- `set -euo pipefail`: 파라미터 조회·파싱 실패 시 빈 값으로 기동되지 않도록 즉시 종료
- `unset`: 임시 변수에 담아 둔 값을 환경 변수로 내보낸 뒤 바로 제거
- `exec java -jar app.jar`: 현재 셸 프로세스를 Java 프로세스로 대체하여 환경 변수 전달

## ECS 환경 변수 주입

태스크 정의의 `containerDefinitions[].secrets[].valueFrom`에 파라미터 ARN 지정 (태스크 실행 역할에 `ssm:GetParameters` 권한 필요)

```json
{
  "executionRoleArn": "arn:aws:iam::123456789012:role/ecsTaskExecutionRole",
  "containerDefinitions": [
    {
      "name": "myapp",
      "image": "123456789012.dkr.ecr.ap-northeast-2.amazonaws.com/myapp:latest",
      "secrets": [
        {
          "name": "SPRING_MAIL_PASSWORD",
          "valueFrom": "arn:aws:ssm:ap-northeast-2:123456789012:parameter/myapp/prod/smtp-password"
        }
      ]
    }
  ]
}
```

## 보안 고려 사항

- 앱이 침해되지 않았을 때 파일 복사·배포 과정에서 평문 설정 파일이 유출되는 위험을 줄이는 수단으로 활용
- EC2 인스턴스 자체가 장악된 경우 환경 변수 주입이나 IAM 역할만으로 방어 불가하며, EC2 인스턴스 메타데이터(IMDS)가 기본 조회 경로가 됨
- 디버깅용 앱 로그에 환경 변수 출력 금지 및 Spring Boot Actuator 엔드포인트 노출 차단 필요
