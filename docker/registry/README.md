## Docker Registry
사설 도커 레지스트리 구축 방법 정리하기

### HTTPS
HTTP 기본 인증 시 사용자 이름과 비밀번호가 헤더에 포함되므로 반드시 HTTPS 통신을 사용하도록 레지스트리 서버를 구축한다. 클라이언트 인증서는 자체적으로 인증서를 발급하거나 [mkcert](https://github.com/FiloSottile/mkcert)를 이용해서 만들 수 있다. 다만, 실제 운용 환경에서는 신뢰할 수 있는 기관으로부터 발급받은 도메인 인증서를 사용해야한다.

- certs/client.cert
- certs/client.key

#### 로컬 인증서 발급 예시
```sh
mkcert -ecdsa -cert-file certs/client.cert -key-file certs/client.key localhost 127.0.0.1 ::1 mambo.kr
```

### 사용자 인증
`htpasswd`를 사용해서 사용자 이름:암호화된 비밀번호 형태의 인증을 위한 파일을 생성한다. 비밀번호는 `bcrypt`로 암호화 되어야한다.

```ps
docker run --rm -ti --entrypoint htpasswd httpd:2-alpine -Bbn mambo mambo | Set-Content -Encoding ASCII htpasswd
```

### 트러블슈팅

**로그인 인증 실패**
다음과 같이 로그인 실패 오류가 발생한다면 REGISTRY_HTTP_HOST 환경변수 또는 htpasswd 파일이 아스키로 구성되었는지 확인해야한다.
```
PS C:\Users\Mambo\docker\registry> docker login mambo.kr:5000 -u mambo -p mambo
WARNING! Using --password via the CLI is insecure. Use --password-stdin.
Error response from daemon: login attempt to http://mambo.kr:5000/v2/ failed with status: 400 Bad Request
```

**S3 버킷 권한**
S3 액세스 권한이 없다면 다음과 같이 IAM 사용자가 S3 서비스 권한이나 버킷 정책에 IAM 사용자가 포함되어있는지 확인해야한다.

```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": [
        "s3:ListBucket",
        "s3:GetBucketLocation",
        "s3:ListBucketMultipartUploads"
      ],
      "Resource": "arn:aws:s3:::S3_BUCKET_NAME",
      "Principal": {
        "AWS": "arn:aws:iam::ACCOUNT_ID:user/S3_IAM_USER"
      },
    },
    {
      "Effect": "Allow",
      "Action": [
        "s3:PutObject",
        "s3:GetObject",
        "s3:DeleteObject",
        "s3:ListMultipartUploadParts",
        "s3:AbortMultipartUpload"
      ],
      "Resource": "arn:aws:s3:::S3_BUCKET_NAME/*",
      "Principal": {
        "AWS": "arn:aws:iam::ACCOUNT_ID:user/S3_IAM_USER"
      },
    }
  ]
}
```