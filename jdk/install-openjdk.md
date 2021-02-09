## Install OpenJDK

### OpenJDK
> https://jdk.java.net/archive/

- [Archived OpenJDK General-Availability Releases](https://jdk.java.net/archive/)

```zsh
# wget https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_linux-x64_bin.tar.gz
> curl -O https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_linux-x64_bin.tar.gz

> mkdir jdk
> tar -zxvf openjdk-11.0.2_linux-x64_bin.tar.gz -C jdk 
```

```zsh
❯ sudo apt-get install openjdk-11-jdk
[sudo] password for mambo:
Reading package lists... Done
Building dependency tree
Reading state information... Done
The following additional packages will be installed:
  at-spi2-core ca-certificates-java fonts-dejavu-extra java-common libatk-bridge2.0-0 libatk-wrapper-java
  libatk-wrapper-java-jni libatk1.0-0 libatk1.0-data libatspi2.0-0 libgif7 libice-dev libnspr4 libnss3 libpcsclite1
  libpthread-stubs0-dev libsm-dev libx11-6 libx11-dev libxau-dev libxcb1-dev libxdmcp-dev libxt-dev
  openjdk-11-jdk-headless openjdk-11-jre openjdk-11-jre-headless x11proto-core-dev x11proto-dev xorg-sgml-doctools
  xtrans-dev
Suggested packages:
  default-jre libice-doc pcscd libsm-doc libx11-doc libxcb-doc libxt-doc openjdk-11-demo openjdk-11-source visualvm
  libnss-mdns fonts-ipafont-gothic fonts-ipafont-mincho fonts-wqy-microhei | fonts-wqy-zenhei fonts-indic
The following NEW packages will be installed:
  at-spi2-core ca-certificates-java fonts-dejavu-extra java-common libatk-bridge2.0-0 libatk-wrapper-java
  libatk-wrapper-java-jni libatk1.0-0 libatk1.0-data libatspi2.0-0 libgif7 libice-dev libnspr4 libnss3 libpcsclite1
  libpthread-stubs0-dev libsm-dev libx11-dev libxau-dev libxcb1-dev libxdmcp-dev libxt-dev openjdk-11-jdk
  openjdk-11-jdk-headless openjdk-11-jre openjdk-11-jre-headless x11proto-core-dev x11proto-dev xorg-sgml-doctools
  xtrans-dev
The following packages will be upgraded:
  libx11-6
1 upgraded, 30 newly installed, 0 to remove and 123 not upgraded.
Need to get 277 MB of archives.
After this operation, 436 MB of additional disk space will be used.
Do you want to continue? [Y/n] y
Get:1 http://mirror.kakao.com/ubuntu focal-updates/main amd64 libx11-6 amd64 2:1.6.9-2ubuntu1.1 [574 kB]
Get:2 http://mirror.kakao.com/ubuntu focal/main amd64 libatspi2.0-0 amd64 2.36.0-2 [64.2 kB]
Get:3 http://mirror.kakao.com/ubuntu focal/main amd64 at-spi2-core amd64 2.36.0-2 [48.7 kB]
Get:4 http://mirror.kakao.com/ubuntu focal/main amd64 java-common all 0.72 [6816 B]
Get:5 http://mirror.kakao.com/ubuntu focal/main amd64 libnspr4 amd64 2:4.25-1 [107 kB]
Get:6 http://mirror.kakao.com/ubuntu focal-updates/main amd64 libnss3 amd64 2:3.49.1-1ubuntu1.5 [1256 kB]
Get:7 http://mirror.kakao.com/ubuntu focal/main amd64 libpcsclite1 amd64 1.8.26-3 [22.0 kB]
Get:8 http://mirror.kakao.com/ubuntu focal-updates/main amd64 openjdk-11-jre-headless amd64 11.0.9.1+1-0ubuntu1~20.04 [37.8 MB]
Get:9 http://mirror.kakao.com/ubuntu focal/main amd64 ca-certificates-java all 20190405ubuntu1 [12.2 kB]
Get:10 http://mirror.kakao.com/ubuntu focal/main amd64 fonts-dejavu-extra all 2.37-1 [1953 kB]
Get:11 http://mirror.kakao.com/ubuntu focal/main amd64 libatk1.0-data all 2.35.1-1ubuntu2 [2964 B]
Get:12 http://mirror.kakao.com/ubuntu focal/main amd64 libatk1.0-0 amd64 2.35.1-1ubuntu2 [45.5 kB]
Get:13 http://mirror.kakao.com/ubuntu focal-updates/main amd64 libatk-bridge2.0-0 amd64 2.34.2-0ubuntu2~20.04.1 [58.2 kB]
Get:14 http://mirror.kakao.com/ubuntu focal/main amd64 libatk-wrapper-java all 0.37.1-1 [53.0 kB]
Get:15 http://mirror.kakao.com/ubuntu focal/main amd64 libatk-wrapper-java-jni amd64 0.37.1-1 [45.1 kB]
Get:16 http://mirror.kakao.com/ubuntu focal/main amd64 libgif7 amd64 5.1.9-1 [32.2 kB]
Get:17 http://mirror.kakao.com/ubuntu focal/main amd64 xorg-sgml-doctools all 1:1.11-1 [12.9 kB]
Get:18 http://mirror.kakao.com/ubuntu focal/main amd64 x11proto-dev all 2019.2-1ubuntu1 [594 kB]
Get:19 http://mirror.kakao.com/ubuntu focal/main amd64 x11proto-core-dev all 2019.2-1ubuntu1 [2620 B]
Get:20 http://mirror.kakao.com/ubuntu focal/main amd64 libice-dev amd64 2:1.0.10-0ubuntu1 [47.8 kB]
Get:21 http://mirror.kakao.com/ubuntu focal/main amd64 libpthread-stubs0-dev amd64 0.4-1 [5384 B]
Get:22 http://mirror.kakao.com/ubuntu focal/main amd64 libsm-dev amd64 2:1.2.3-1 [17.0 kB]
Get:23 http://mirror.kakao.com/ubuntu focal/main amd64 libxau-dev amd64 1:1.0.9-0ubuntu1 [9552 B]
Get:24 http://mirror.kakao.com/ubuntu focal/main amd64 libxdmcp-dev amd64 1:1.1.3-0ubuntu1 [25.3 kB]
Get:25 http://mirror.kakao.com/ubuntu focal/main amd64 xtrans-dev all 1.4.0-1 [68.9 kB]
Get:26 http://mirror.kakao.com/ubuntu focal/main amd64 libxcb1-dev amd64 1.14-2 [80.5 kB]
Get:27 http://mirror.kakao.com/ubuntu focal-updates/main amd64 libx11-dev amd64 2:1.6.9-2ubuntu1.1 [649 kB]
Get:28 http://mirror.kakao.com/ubuntu focal/main amd64 libxt-dev amd64 1:1.1.5-1 [395 kB]
Get:29 http://mirror.kakao.com/ubuntu focal-updates/main amd64 openjdk-11-jre amd64 11.0.9.1+1-0ubuntu1~20.04 [34.6 kB]
Get:30 http://mirror.kakao.com/ubuntu focal-updates/main amd64 openjdk-11-jdk-headless amd64 11.0.9.1+1-0ubuntu1~20.04 [232 MB]
Get:31 http://mirror.kakao.com/ubuntu focal-updates/main amd64 openjdk-11-jdk amd64 11.0.9.1+1-0ubuntu1~20.04 [1882 kB]
Fetched 277 MB in 6s (47.9 MB/s)
Extracting templates from packages: 100%
(Reading database ... 50996 files and directories currently installed.)
...
Setting up java-common (0.72) ...
Setting up libpthread-stubs0-dev:amd64 (0.4-1) ...
Setting up xtrans-dev (1.4.0-1) ...
Setting up libnspr4:amd64 (2:4.25-1) ...
Setting up libpcsclite1:amd64 (1.8.26-3) ...
Setting up libgif7:amd64 (5.1.9-1) ...
Setting up libatk1.0-data (2.35.1-1ubuntu2) ...
Setting up fonts-dejavu-extra (2.37-1) ...
Setting up libx11-6:amd64 (2:1.6.9-2ubuntu1.1) ...
Setting up xorg-sgml-doctools (1:1.11-1) ...
Setting up libatk1.0-0:amd64 (2.35.1-1ubuntu2) ...
Setting up libatk-wrapper-java (0.37.1-1) ...
Setting up libnss3:amd64 (2:3.49.1-1ubuntu1.5) ...
Setting up libatspi2.0-0:amd64 (2.36.0-2) ...
Setting up libatk-bridge2.0-0:amd64 (2.34.2-0ubuntu2~20.04.1) ...
Setting up at-spi2-core (2.36.0-2) ...
Setting up libatk-wrapper-java-jni:amd64 (0.37.1-1) ...
Setting up openjdk-11-jre-headless:amd64 (11.0.9.1+1-0ubuntu1~20.04) ...
Setting up openjdk-11-jre:amd64 (11.0.9.1+1-0ubuntu1~20.04) ...
Setting up openjdk-11-jdk-headless:amd64 (11.0.9.1+1-0ubuntu1~20.04) ...
Setting up openjdk-11-jdk:amd64 (11.0.9.1+1-0ubuntu1~20.04) ...
Setting up ca-certificates-java (20190405ubuntu1) ...
head: cannot open '/etc/ssl/certs/java/cacerts' for reading: No such file or directory
...
done.
Processing triggers for fontconfig (2.13.1-2ubuntu3) ...
Processing triggers for mime-support (3.64ubuntu1) ...
Processing triggers for hicolor-icon-theme (0.17-2) ...
Processing triggers for libc-bin (2.31-0ubuntu9) ...
Processing triggers for man-db (2.9.1-1) ...
Processing triggers for ca-certificates (20201027ubuntu0.20.04.1) ...
Updating certificates in /etc/ssl/certs...
0 added, 0 removed; done.
Running hooks in /etc/ca-certificates/update.d...

done.
done.
Processing triggers for sgml-base (1.29.1) ...
Setting up x11proto-dev (2019.2-1ubuntu1) ...
Setting up libxau-dev:amd64 (1:1.0.9-0ubuntu1) ...
Setting up libice-dev:amd64 (2:1.0.10-0ubuntu1) ...
Setting up libsm-dev:amd64 (2:1.2.3-1) ...
Setting up libxdmcp-dev:amd64 (1:1.1.3-0ubuntu1) ...
Setting up x11proto-core-dev (2019.2-1ubuntu1) ...
Setting up libxcb1-dev:amd64 (1.14-2) ...
Setting up libx11-dev:amd64 (2:1.6.9-2ubuntu1.1) ...
Setting up libxt-dev:amd64 (1:1.1.5-1) ...

❯ java --version
openjdk 11.0.9.1 2020-11-04
OpenJDK Runtime Environment (build 11.0.9.1+1-Ubuntu-0ubuntu1.20.04)
OpenJDK 64-Bit Server VM (build 11.0.9.1+1-Ubuntu-0ubuntu1.20.04, mixed mode, sharing)
```

### AdoptOpenJDK
> https://adoptopenjdk.net/index.html

- [OpenJDK 8 + HotSpot](https://adoptopenjdk.net/releases.html?variant=openjdk8&jvmVariant=hotspot)
- [OpenJDK 11 + HotSpot](https://adoptopenjdk.net/releases.html?variant=openjdk11&jvmVariant=hotspot)


### Amazon Corretto
> https://aws.amazon.com/ko/corretto/

- [Downloads for Amazon Corretto 8](https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/downloads-list.html)
- [Downloads for Amazon Corretto 11](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html)
