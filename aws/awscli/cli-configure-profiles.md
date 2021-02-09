# AWS CLI Profiles

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
