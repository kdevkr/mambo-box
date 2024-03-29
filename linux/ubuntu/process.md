## Process

프로세스 명령어 학습

### Nohup 명령어로 백그라운드 프로세스 실행하기

```sh
nohup java -jar -Xmx500m demo.war 1> app.log 2>&1 &
kill -9 `cat app.pid` && rm app.pid
```

### 프로세스 아이디를 가져오는 방법
```sh
# echo $!
nohup java -jar -Xmx500m demo.war 1> app.log 2>&1 & echo $! > current.pid

# JPS(JVM Process Status)
jps -v | grep war | awk '{print $1}'

# ps -ef
ps -ef | grep java | grep -v grep | awk '{print $2}'

# netstat -tnlp
netstat -tnlp | grep java | awk '{print $7}' | awk -F '/' '{print $1}'

# pgrep
pgrep java
```

### Crontab으로 프로세스 실행 유지

```sh
#!/bin/sh

PID_FILE="app.pid"

autorun () {
  # ... & echo $! > app.pid
  nohup java -jar -Xmx500m demo.war 1> app.log 2>&1 &
}

if [ -f "$PID_FILE" ] && [ ! -z `cat "$PID_FILE"` ]; then
  PID=$(cat $PID_FILE)
  if ps -p $PID > /dev/null; then
    echo "$PID_FILE($PID) is running"
  else
    autorun
  fi
else
  autorun
fi
```

### SystemD 서비스 등록

```sh
[Unit]
Description=demo
After=syslog.target

[Service]
User=ec2-user
WorkingDirectory=/home/ec2-user
ExecStart=/usr/bin/java -jar -Xmx500m demo.war
ExecStop=kill -9 `cat app.pid`
SuccessExitStatus=143
Restart=on-failure
RestartSec=5s

[Install]
WantedBy=multi-user.target
```