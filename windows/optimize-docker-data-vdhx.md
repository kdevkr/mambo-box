## docker_data.vdhx 파일 크기 최적화

```powershell
Optimize-VHD -Path $Env:LOCALAPPDATA\Docker\wsl\disk\docker_data.vhdx -Mode Full
```

- Windows Powershell 을 **관리자 권한**으로 실행
- **Optimize-VHD** 명령어 실행 후 **54.7GB** 에서 **36.5GB** 로 압축

