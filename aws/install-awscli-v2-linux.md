## Linux에서 AWS CLI 버전 2 설치, 업데이트 및 제거
> https://docs.aws.amazon.com/ko_kr/cli/latest/userguide/install-cliv2-linux.html

### 64비트 리눅스용 AWS CLI 버전 2 다운로드
```sh
[centos@localhost ~]$ curl 'https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip' -o 'awscliv2.zip'
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100 33.7M  100 33.7M    0     0  48.0M      0 --:--:-- --:--:-- --:--:-- 48.0M

[centos@localhost ~]$ unzip awscliv2.zip
-bash: unzip: command not found
```

(Optional) unzip 설치
```sh
[centos@localhost ~]$ sudo yum install unzip
[sudo] password for centos:
Last metadata expiration check: 10:05:51 ago on Wed 10 Feb 2021 10:02:16 AM KST.
Dependencies resolved.
========================================================================================================================
 Package                   Architecture               Version                          Repository                  Size
========================================================================================================================
Installing:
 unzip                     x86_64                     6.0-43.el8                       baseos                     195 k

Transaction Summary
========================================================================================================================
Install  1 Package

Total download size: 195 k
Installed size: 413 k
Is this ok [y/N]: y
Downloading Packages:
unzip-6.0-43.el8.x86_64.rpm                                                             2.3 MB/s | 195 kB     00:00
------------------------------------------------------------------------------------------------------------------------
Total                                                                                   324 kB/s | 195 kB     00:00
Running transaction check
Transaction check succeeded.
Running transaction test
Transaction test succeeded.
Running transaction
  Preparing        :                                                                                                1/1
  Installing       : unzip-6.0-43.el8.x86_64                                                                        1/1
  Running scriptlet: unzip-6.0-43.el8.x86_64                                                                        1/1
  Verifying        : unzip-6.0-43.el8.x86_64                                                                        1/1

Installed:
  unzip-6.0-43.el8.x86_64

Complete!

[centos@localhost ~]$ unzip awscliv2.zip
Archive:  awscliv2.zip
   creating: aws/
   creating: aws/dist/
   ...
[centos@localhost ~]$ sudo ./aws/install
You can now run: /usr/local/bin/aws --version

[centos@localhost ~]$ /usr/local/bin/aws --version
aws-cli/2.1.25 Python/3.7.3 Linux/4.18.0-240.10.1.el8_3.x86_64 exe/x86_64.centos.8 prompt/off
```

