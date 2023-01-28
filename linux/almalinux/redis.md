#### Redis용 서버 설치 메뉴얼

- AlmaLinux 8.7  
- Redis 6 


#### 기본 패키지 업데이트 및 추가 패키지 설치
```shell
$ sudo dnf update -y
$ sudo dnf install -y vim net-tools
```

#### 기본 커널 옵션 조정
```shell
$ sysctl -w vm.swappiness=0
$ sysctl -w vm.overcommit_memory=1
$ sysctl -w vm.max_map_count=262144
$ sysctl -w net.core.somaxconn=65535

$ echo "vm.swappiness=0" >> /etc/sysctl.conf
$ echo "vm.overcommit_memory=1" >> /etc/sysctl.conf
$ echo "vm.max_map_count=262144" >> /etc/sysctl.conf
$ echo "net.core.somaxconn=65535" >> /etc/sysctl.conf
```

#### THP 비활성화
```shell
$ echo never > /sys/kernel/mm/transparent_hugepage/enabled
$ "echo never > /sys/kernel/mm/transparent_hugepage/enabled" >> /etc/rc.local
```

#### Redis 사용자에 대한 ulimit 설정
```shell
$ "redis soft    nofile  65535" >> /etc/security/limits.conf
$ "redis hard    nofile  65535" >> /etc/security/limits.conf
$ "redis soft    nproc   4096" >> /etc/security/limits.conf
$ "redis hard    nproc   4096" >> /etc/security/limits.conf
```

#### Redis 6 설치
```shell
$ sudo dnf module enable redis:6 -y
$ sudo dnf install redis -y
```

#### Redis 설정 및 서비스 실행
```shell
sudo vi /etc/redis.conf
  bind 0.0.0.0 ::
  port 6379
  requirepass redispass
  maxmemory 500mb
  maxmemory-policy allkeys-lfu
  disable-thp yes
  appendonly no

$ sudo systemctl start redis
$ sudo systemctl enable redis
```

#### Redis 테스트
```shell
redis-cli
  AUTH redispass
  info server
  info memory
```

