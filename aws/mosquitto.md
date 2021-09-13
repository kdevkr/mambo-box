## Amazon Linux 2 AMI에서 Mosquitto 설치

```bash
# https://aws.amazon.com/ko/premiumsupport/knowlege-center/ec2-enable-epel
# EPEL 릴리스 패키지 설치
sudo amazon-linux-extras install epel

# Mosquitto 패키지 설치
sudo yum install mosquitto

cd /etc/mosquitto
sudo vi password_file
sudo mosquitto_passwd -b passwordfile [username] [userpass]

sudo systemctl start mosquitto.service
sudo systemctl status mosquitto.service
```