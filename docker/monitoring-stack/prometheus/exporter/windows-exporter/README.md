# Windows Exporter
[Download Windows Exporter](https://github.com/prometheus-community/windows_exporter/releases)

```cmd
.\windows_exporter-0.16.0-386.exe --collectors.enabled "cpu,net,cs"
```

## Pushgateway와 연계
Windows용 cURL 다운로드 - https://curl.se/windows/

```cmd Windows Terminal
powershell -Command "Invoke-WebRequest -Uri http://127.0.0.1:9091/metrics/job/windows-exporter/instance/1 -Method POST -Body \"ping 1`n\""
```

```bat ping.bat
@echo off
powershell -Command "Invoke-WebRequest -Uri http://127.0.0.1:9091/metrics/job/windows-exporter/instance/1 -Method POST -Body \"ping 1`n\""
```
