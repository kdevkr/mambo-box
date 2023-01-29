#### Elasticsearch용 서버 설치 메뉴얼
- AlmaLinux 8.7
- Elasticsearch 7
- Kibana 7

#### 기본 패키지 업데이트 및 추가 패키지 설치
```shell
sudo dnf update -y
sudo dnf install -y vim net-tools wget
```

#### 기본 커널 옵션 조정
```shell
sudo sysctl -w vm.swappiness=1
sudo sysctl -w vm.overcommit_memory=1
sudo sysctl -w vm.max_map_count=262144
sudo sysctl -w net.core.somaxconn=65535

# 서버 재시작 시에도 반영
sudo echo "vm.swappiness=1" >> /etc/sysctl.conf
sudo echo "vm.overcommit_memory=1" >> /etc/sysctl.conf
sudo echo "vm.max_map_count=262144" >> /etc/sysctl.conf
sudo echo "net.core.somaxconn=65535" >> /etc/sysctl.conf
sudo sysctl -a | grep somaxconn
```

#### THP 비활성화
```shell
sudo echo never > /sys/kernel/mm/transparent_hugepage/enabled
sudo echo never > /sys/kernel/mm/transparent_hugepage/defrag
# 서버 재시작 시에도 반영
sudo "echo never > /sys/kernel/mm/transparent_hugepage/enabled" >> /etc/rc.local
sudo "echo never > /sys/kernel/mm/transparent_hugepage/defrag" >> /etc/rc.local
```

#### elasticsearch 사용자에 대한 ulimit 설정
```shell
$ "elasticsearch  soft  nofile    65535" >> /etc/security/limits.conf
$ "elasticsearch  hard  nofile    65535" >> /etc/security/limits.conf
$ "elasticsearch  soft  nproc     65535" >> /etc/security/limits.conf
$ "elasticsearch  hard  nproc     65535" >> /etc/security/limits.conf
$ "elasticsearch  soft  memlock   65535" >> /etc/security/limits.conf
$ "elasticsearch  hard  memlock   65535" >> /etc/security/limits.conf
```

#### Elasticsearch 7 tar.gz 다운로드
```shell
wget https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-7.3.2-linux-x86_64.tar.gz
wget https://artifacts.elastic.co/downloads/kibana/kibana-7.3.2-linux-x86_64.tar.gz

tar zxvf elasticsearch-7.3.2-linux-x86_64.tar.gz
tar zxvf kibana-7.3.2-linux-x86_64.tar.gz

# 키바나 기본 폴더명 변경
mv kibana-7.3.2-linux-x86_64 kibana-7.3.2
```

#### Elasticsearch 설정 및 서비스 실행
```shell
vi elasticsearch-7.3.2/config/elasticsearch.yml
  cluster.name: single-cluster
  node.name: node-1
  node.master: true
  path.data: /data/elasticsearch
  bootstrap.memory_ock: true
  network.host: "0.0.0.0"
  http.port: 9200
  transport.port: 9300
  cluster.initial_master_nodes: ["node-1"]
  xpack.security.enable: false

vi elasticsearch-7.3.2/config/jvm.options
  -Xms8g
  -Xmx8g
```
