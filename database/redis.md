## Redis
오늘날 대부분의 시스템에서 **세션 또는 캐시 데이터 저장소**로써 도입하는 비정형 데이터베이스 솔루션이다. 시스템 규모에 따라서 단일 인스턴스와 레디스 클러스터를 구성하며 최신 버전에서는 멀티 스레드 I/O를 지원하기는 하나 대부분 성능 상의 이유로 **단일 스레드**로 운용한다. 시스템 아키텍처 상 캐시 계층은 시스템을 더 효율적으로 운영할 수 있도록 구성할 수 있는 장점을 제공하지만 시스템 규모와 저장되는 데이터의 규모에 따라 레디스 클러스터에 대한 관리 문제로 라인과 같은 조직에서는 [레디스 전문 엔지니어](https://careers.linecorp.com/ko/jobs/1095)로 구성된 팀을 별도로 만들기도 한다.  

#### 클라이언트
- [redis-cli](https://redis.io/docs/manual/cli/)
- [lettuce](https://lettuce.io/)
- [go-redis](https://github.com/go-redis/redis)

```shell
# redis-cli in ubuntu
$ sudo apt install redis-tools
$ redis-cli -v
redis-cli 6.0.16
```

#### 글 또는 영상
- [ZooKeeper를 활용한 Redis Cluster 관리](https://d2.naver.com/helloworld/294797)
- [쿠버네티스에 레디스 캐시 클러스터 구축기](https://tech.kakao.com/2022/02/09/k8s-redis/)
- [Kubernetes와 Redis를 이용한 캐시 팜 구성](https://tech.kakao.com/2020/11/10/if-kakao-2020-commentary-01-kakao/)
- [NHN FORWARD, 레디스 야무지게 사용하기](https://www.youtube.com/watch?v=92NizoBL4uA)
- [우아한테크세미나, 우아한 레디스](https://www.youtube.com/watch?v=mPB2CZiAkKM)
- [개발자를 위한 레디스 튜토리얼 01](https://meetup.toast.com/posts/224)
- [ElastiCache for Redis 사용 시 지연 시간이 긴 문제를 해결하려면 어떻게 해야 합니까?](https://aws.amazon.com/ko/premiumsupport/knowledge-center/elasticache-redis-correct-high-latency/)

