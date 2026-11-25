# AWS Secrets Manager

DB 비밀번호, API 키 등 민감정보를 안전하게 저장·관리하는 서비스

- [AWS Secrets Manager Documentation](https://docs.aws.amazon.com/secretsmanager/)

## 특징

- 여러 키-값 쌍을 하나의 JSON 객체로 묶어 관리 가능
- 자동 회전(Rotation) 기능 지원
- 시크릿 저장(월 과금) 및 API 호출에 따른 비용 발생
- 애플리케이션이 비밀번호 자동 교체를 함께 지원하지 않는 경우 비용 대비 실익 검토 필요

## IAM 권한 설정

조회 주체에 따라 권한을 부여하는 IAM 역할 구분 필요

- **EC2**: 인스턴스 프로파일 역할(EC2 역할)
- **ECS (런타임 직접 조회)**: 컨테이너 내부에서 직접 AWS API 호출 시 태스크 역할(`taskRoleArn`)
- **ECS (`secrets.valueFrom` 주입)**: 컨테이너 시작 시 ECS가 환경 변수로 주입할 때 태스크 실행 역할(`executionRoleArn`)

```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": "secretsmanager:GetSecretValue",
      "Resource": "arn:aws:secretsmanager:ap-northeast-2:123456789012:secret:myapp/prod-*"
    },
    {
      "Effect": "Allow",
      "Action": "kms:Decrypt",
      "Resource": "arn:aws:kms:ap-northeast-2:123456789012:key/<kms-key-id>"
    }
  ]
}
```

- `Resource`는 `*` 대신 필요한 시크릿 ARN으로 최소 권한 제한 권장 (Secrets Manager의 6자리 랜덤 접미사를 고려해 `-*` 패턴 사용)
- 기본 키(`aws/secretsmanager`) 사용 시 `kms:Decrypt` Statement 생략 가능
- 사용자 관리 KMS 키(CMK)로 암호화한 경우 IAM 정책의 `kms:Decrypt` 외에 해당 KMS 키 리소스 정책(Key Policy)에서도 역할 허용 필요

## EC2 환경 변수 주입

애플리케이션 실행 전 배포 스크립트에서 AWS CLI로 JSON 시크릿을 조회하고 `jq`로 필요한 키만 추출하여 주입

```bash
#!/usr/bin/env bash
set +x
set -euo pipefail

secret="$(aws secretsmanager get-secret-value \
  --secret-id myapp/prod \
  --query SecretString \
  --output text)"

export SPRING_DATASOURCE_USERNAME="$(jq -er '.DB_USERNAME' <<< "$secret")"
export SPRING_DATASOURCE_PASSWORD="$(jq -er '.DB_PASSWORD' <<< "$secret")"
export APP_API_KEY="$(jq -er '.API_KEY' <<< "$secret")"

unset secret
exec java -jar app.jar
```

- `set +x`: 상위 셸이나 CI/CD 환경의 디버그 추적 활성화 시 조회 값이 로그에 출력되는 현상 방지
- `set -euo pipefail`: 시크릿 조회·파싱 실패 시 빈 값으로 기동되지 않도록 즉시 종료
- `jq -er`: 지정한 키가 없거나 값이 `null`이면 비정상 종료 코드 반환
- `unset secret`: 필요한 환경 변수만 내보낸 뒤 원본 JSON 문자열 제거
- `exec java -jar app.jar`: 현재 셸 프로세스를 Java 프로세스로 대체하여 환경 변수 전달

## ECS 환경 변수 주입

별도 래퍼 스크립트 없이 태스크 정의의 `containerDefinitions[].secrets[].valueFrom` 필드로 주입

```json
{
  "executionRoleArn": "arn:aws:iam::123456789012:role/ecsTaskExecutionRole",
  "containerDefinitions": [
    {
      "name": "myapp",
      "image": "123456789012.dkr.ecr.ap-northeast-2.amazonaws.com/myapp:latest",
      "secrets": [
        {
          "name": "SPRING_DATASOURCE_USERNAME",
          "valueFrom": "arn:aws:secretsmanager:ap-northeast-2:123456789012:secret:myapp/prod-AbCdEf:DB_USERNAME::"
        },
        {
          "name": "SPRING_DATASOURCE_PASSWORD",
          "valueFrom": "arn:aws:secretsmanager:ap-northeast-2:123456789012:secret:myapp/prod-AbCdEf:DB_PASSWORD::"
        },
        {
          "name": "APP_API_KEY",
          "valueFrom": "arn:aws:secretsmanager:ap-northeast-2:123456789012:secret:myapp/prod-AbCdEf:API_KEY::"
        }
      ]
    }
  ]
}
```

- `valueFrom` 형식: `arn:aws:secretsmanager:<region>:<account-id>:secret:<secret-name>:<json-key>:<version-stage>:<version-id>`
- 끝의 `::`처럼 버전 스테이지와 버전 ID를 비워 두면 현재 활성화된 최신 버전(`AWSCURRENT`) 조회

## 보안 고려 사항

- EC2 인스턴스 자체가 장악된 경우 환경 변수 주입이나 IAM 역할만으로 민감정보 유출 방어 불가
- SSRF 등 침해 경로에서 EC2 인스턴스 메타데이터(IMDS)는 기본 조회 경로로 악용 가능
- 디버깅용 앱 로그에 환경 변수 출력 금지 및 Spring Boot Actuator 엔드포인트 노출 차단 필요
