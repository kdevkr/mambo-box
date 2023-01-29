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
$ "@elasticsearch  soft  nofile    65535" >> /etc/security/limits.conf
$ "@elasticsearch  hard  nofile    65535" >> /etc/security/limits.conf
$ "@elasticsearch  soft  nproc     65535" >> /etc/security/limits.conf
$ "@elasticsearch  hard  nproc     65535" >> /etc/security/limits.conf
$ "@elasticsearch  soft  memlock   65535" >> /etc/security/limits.conf
$ "@elasticsearch  hard  memlock   65535" >> /etc/security/limits.conf
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
  
# 엘라스틱서치 실행 스크립트 추가
vi elasticsearch-7.3.2/start.sh
  #!/bin/bash
  ES_USER="ec2-user"
  ES_HOME="/home/$ES_USER/elasticsearch-7.3.2"
  PID=`ps aux | grep $ES_HOME | pidof java`
  ps aux | grep $ES_HOME | pidof java > /dev/null
  RESULT=$?

  if [ 0 = $RESULT ]; then
      echo "[`date --rfc-3339=seconds`] [WARN] Already running with pid($PID)."
  else
      echo "[`date --rfc-3339=seconds`] [INFO] Starting elasticsearch..."
      ${ES_HOME}/bin/elasticsearch -d -p ${ES_HOME}/elasticsearch.pid
  fi

# 엘라스틱서치 종료 스크립트 추가
vi elasticsearch-7.3.2/stop.sh
  #!/bin/bash
  ES_USER="ec2-user"
  ES_HOME="/home/$ES_USER/elasticsearch-7.3.2"
  PID=`ps aux | grep $ES_HOME | pidof java`
  ps aux | grep $ES_HOME | pidof java > /dev/null
  RESULT=$?

  if [ 0 = $RESULT ]; then
      echo "[`date --rfc-3339=seconds`] [INFO] Stopping elasticsearch..."
      kill -15 $PID

      sleep 3

      ps aux | grep $ES_HOME | pidof java > /dev/null
      RESULT=$?

      if [ 0 = $RESULT ]; then
          echo "[`date --rfc-3339=seconds`] [ERROR] Cannot stop elasticsearch"
      else
          echo "[`date --rfc-3339=seconds`] [INFO] Stopped elasticsearch."
      fi
  else
      echo "[`date --rfc-3339=seconds`] [WARN] Elasticsearch not running."
  fi
```

#### Kibana 설정 및 서비스 실행
```shell
vi kibana-7.3.2/config/kibana.yml
  server.port: 5601
  server.host: "0.0.0.0"
  elasticsearch.hosts: ["http://localhost:9200"]
  pid.file: "/home/ec2-user/kibana-7.3.2/kibana.pid"
  logging.dest: "/home/ec2-user/kibana-7.3.2/kibana.log"

# 키바나 실행 스크립트 추가
vi kibana-7.3.2/start.sh
  #!/bin/bash
  KBN_USER="ec2-user"
  KBN_HOME="/home/$KBN_USER/kibana-7.3.2"
  PID=`ps aux | grep $KBN_HOME | pidof node`
  ps aux | grep $KBN_HOME | pidof node > /dev/null
  RESULT=$?

  if [ 0 = $RESULT ]; then
      echo "[`date --rfc-3339=seconds`] [WARN] Already running with pid($PID)."
  else
      echo "[`date --rfc-3339=seconds`] [INFO] Starting kibana..."
      nohup $KBN_HOME/bin/kibana > /dev/null 2>&1 &
  fi

# 키바나 종료 스크립트 추가
vi kibana-7.3.2/stop.sh
  #!/bin/bash
  KBN_USER="ec2-user"
  KBN_HOME="/home/$KBN_USER/kibana-7.3.2"
  PID=`ps aux | grep $KBN_HOME | pidof node`
  ps aux | grep $KBN_HOME | pidof node > /dev/null
  RESULT=$?

  if [ 0 = $RESULT ]; then
      echo "[`date --rfc-3339=seconds`] [INFO] Stopping kibana..."
      kill -15 $PID

      sleep 3

      ps aux | grep $KBN_HOME | pidof node > /dev/null
      RESULT=$?

      if [ 0 = $RESULT ]; then
          echo "[`date --rfc-3339=seconds`] [ERROR] Cannot stop kibana"
      else
          echo "[`date --rfc-3339=seconds`] [INFO] Stopped kibana."
      fi
  else
      echo "[`date --rfc-3339=seconds`] [WARN] Kibana not running."
  fi
```

#### 엘라스틱서치 및 키바나 재실행을 위한 크론탭 설정
```shell
crontab -e
  * * * * * /bin/sh /home/ec2-user/elasticsearch-7.3.2/start.sh >> /home/ec2-user/elasticsearch-7.3.2/cron.log
  @reboot /bin/sh /home/ec2-user/elasticsearch-7.3.2/start.sh >> /home/ec2-user/elasticsearch-7.3.2/cron.log

  * * * * * /bin/sh /home/ec2-user/kibana-7.3.2/start.sh >> /home/ec2-user/kibana-7.3.2/cron.log
  @reboot /bin/sh /home/ec2-user/kibana-7.3.2/start.sh >> /home/ec2-user/kibana-7.3.2/cron.log
```
