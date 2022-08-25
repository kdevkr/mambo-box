## AWS CLI

### 설치
AWS CLI Version 2 설치를 권장한다.

- [AWS CLI v2 Documentation](https://github.com/aws/aws-cli/tree/v2#installation)
- [Installing, updating, and uninstalling the AWS CLI version 2](https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2.html)

```ps
PS C:\Users\Mambo> aws --version
aws-cli/2.2.30 Python/3.8.8 Windows/10 exe/AMD64 prompt/off
```

```sh
sudo apt-get install curl unzip
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip" \
&& unzip awscliv2.zip \
&& sudo ./aws/install

aws --version
aws-cli/2.2.41 Python/3.8.8 Linux/5.4.0-84-generic exe/x86_64.ubuntu.20 prompt/off
```

### AWS CLI Profiles

AWS CLI에서 사용되는 자격 증명에 대해서 명명된 프로파일로 저장하고 AWS CLI를 사용할 때 프로파일을 지정하거나 환경변수 AWS_PROFILE에 프로파일을 지정하자.

```sh
aws configure --profile mambo
AWS Access Key ID [None]: ****************GD2C
AWS Secret Access Key [None]: ****************QHrA
Default region name [None]: ap-northeast-2
Default output format [None]:

aws configure list --profile mambo
      Name                    Value             Type    Location
      ----                    -----             ----    --------
   profile                    mambo           manual    --profile
access_key     ****************GD2C shared-credentials-file
secret_key     ****************QHrA shared-credentials-file
    region           ap-northeast-2      config-file    ~/.aws/config

export AWS_PROFILE=mambo
```

### AWS CLI Examples

#### EC2 인스턴스 정보 조회하기
```sh
aws ec2 describe-instances --query "Reservations[].Instances[].{Name: Tags[?Key == 'Name'].Value | [0], Id: InstanceId, State: State.Name, Type: InstanceType}" --output table --profile mambo
```

#### S3 버킷 목록 조회하기
```sh
aws s3 ls s3:// --profile mambo
```
