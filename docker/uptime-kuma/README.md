## Uptime Kuma  
Synthetic Monitoring을 위한 서비스 상태 체크 대시보드 오픈소스

**docker-compose.yml**
```yaml
version: "3"
services:
  uptime-kuma:
    image: louislam/uptime-kuma:1
    container_name: uptime-kuma
    ports:
      - "3001:3001"
    volumes:
      - uptime-kuma-data:/app/data

volumes:
  uptime-kuma-data:
```

### Nginx Websocket Proxy  
Uptime Kuma는 Websocket를 사용하므로 Nginx를 통한 프록시를 구성하는 경우 /socket.io 경로에 대한 웹소켓 프록시를 설정해야한다.

> https://github.com/louislam/uptime-kuma/wiki/Reverse-Proxy#nginx

### Slack Notification
슬랙 채널과의 알림 연동을 위한 [Incoming WebHooks](https://slack.com/apps/A0F7XDUAZ-incoming-webhooks) 추가

- Webhook URL: https://hooks.slack.com/services/T3RJGRX26/B038ML76MT8/6nJt3LmZ4oMx3UzucCm#####
- ChannelName: #uptime

아쉽게도 커스텀 알림 메시지 템플릿은 지원하지 않는다.