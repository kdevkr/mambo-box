# 프로세스 종료

## lsof

```sh
# 8080 포트를 사용하는 모든 프로세스에 SIGTERM 전송
PORT=8080
lsof -t -i:$PORT | xargs -r kill -15
```

## pgrep

```sh
PORT=8080
lsof -t -i:$PORT | xargs -r kill -15
```

## ss

```sh
#!/bin/bash

# 첫 번째 인자($1)를 포트로 사용, 없으면 기본값 8080
PORT=${1:-8080}

echo "Target Port: $PORT"

# 명령어 실행
sudo ss -lptn "sport = :$PORT" | grep -Po 'pid=\K[0-9]+' | xargs -r kill -15
```
