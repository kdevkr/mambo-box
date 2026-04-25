# 프로세스 종료

## 프로세스 아이디를 찾아서 종료하기
### lsof

```sh
# 8080 포트를 사용하는 모든 프로세스에 SIGTERM 전송
PORT=8080
lsof -t -i:$PORT | xargs -r kill -15
```

### pgrep

```sh
PORT=8080
pgrep -f "p $PORT" | xargs -r kill -15
```

### ss

```sh
#!/bin/bash

# 첫 번째 인자($1)를 포트로 사용, 없으면 기본값 8080
PORT=${1:-8080}

echo "Target Port: $PORT"

# 명령어 실행
sudo ss -lptn "sport = :$PORT" | grep -Po 'pid=\K[0-9]+' | xargs -r kill -15
```

## 안전하게 종료하기 위한 방어 코드

### 변수 할당 및 교차 검증

```sh
PID_FILE="${1:?PID 파일 경로가 필요합니다.}"
PATTERN="${2:?프로세스 매칭 패턴이 필요합니다.}"

# PID 파일 존재 여부와 패턴 일치를 동시에 검증 (pgrep -F)
if pgrep -F "$PID_FILE" -f "$PATTERN" > /dev/null; then
    kill -15 $(cat "$PID_FILE")
    # 종료 확인 후 PID 파일 삭제
    sleep 1
    kill -0 $(cat "$PID_FILE") 2>/dev/null || rm -f "$PID_FILE"
fi
```

### Wait & Kill

SIGTERM(15) 으로 일정시간을 기다리고 SIGKILL(9)로 종료

```sh
kill -15 $PID
for i in {1..10}; do
  kill -0 $PID 2>/dev/null || exit 0
  sleep 1
done
kill -9 $PID
```
