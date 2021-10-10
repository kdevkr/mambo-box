# AlmaLinux

## Setup

**Install Some Packages**

```sh
sudo yum install vim net-tools unzip
```

### Amazon Corretto 11 Installation Instructions for RPM-Based Linux Distributions

```sh
sudo rpm --import https://yum.corretto.aws/corretto.key
sudo curl -L -o /etc/yum.repos.d/corretto.repo https://yum.corretto.aws/corretto.repo
sudo yum install -y java-11-amazon-corretto-devel
```

### Installing the AWS CLI version 2 on Linux

```sh
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
# sudo yum install unzip
unzip awscliv2.zip
sudo ./aws/install
```