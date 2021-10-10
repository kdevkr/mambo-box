
## 리눅스에서 Logrotate 설정하기
Logrotate는 리눅스 시스템에서 사용하는 로그 관리 유틸리티이다.

기본적으로 cron.daily에 의해 매일 주기적으로 실행되며 /etc/logrotate.d 폴더에 Logrotate 설정 파일을 작성한다.

**/etc/logrotate.d/app**
```
/var/current/app/*.log {
    daily
    rotate 30
    size 1k
    missingok
    notifempty
    compress
    dateext
    create
    copytruncate
    nomail
    olddir /var/current/app/rotate
}
```

Log4j 또는 Logback을 사용하지 않는 애플리케이션은 로그 파일을 Rolling 방법이 없으므로 logrotate를 설정해야한다.

logrotate에 롤링된 파일은 AWS의 S3로 백업할 수 있다.

