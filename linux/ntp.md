## NTP

리눅스 서버 시스템은 NTP(Network Time Protocol)을 사용하여 시스템을 구성하는 서버 간의 시간을 동기화하며 주로 Chrony 패키지를 사용한다. AWS 환경의 아마존 리눅스 또는 우분투 이미지에서는 기본적으로 Amazon Time Sync 서비스를 통해서 자체적으로 시간을 동기화하므로 클라우드 환경에서는 개발자로써 별다른 조치를 할 필요는 없다.

#### 참고 문서
- [Building a more accurate time service at Facebook scale](https://engineering.fb.com/2020/03/18/production-engineering/ntp-service/)
- [Amazon Time Sync is now available over the internet as a public NTP service](https://aws.amazon.com/about-aws/whats-new/2022/11/amazon-time-sync-internet-public-ntp-service)
- [Linux 인스턴스의 시간 설정 - Ubuntu에서 Amazon Time Sync Service 구성](https://docs.aws.amazon.com/ko_kr/AWSEC2/latest/UserGuide/set-time.html#configure-amazon-time-service-ubuntu)
