#### 윈도우 터미널에서 오픈중인 포트 프로세스 확인하는 방법

```powershell
netstat -ano | findstr ":8080"
```

#### 윈도우 NAT 서비스 재시작 하기

```powershell
# 관리자 권한으로 실행
net stop winnat
net start winnat
```
> https://stackoverflow.com/a/65698209
