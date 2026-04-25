## Windows Subsystem for Linux

- [Windows 10에 Linux용 Windows 하위 시스템 설치 가이드](https://docs.microsoft.com/ko-kr/windows/wsl/install-win10)
- [WSL2 설치 및 사용 방법](https://www.44bits.io/ko/post/wsl2-install-and-basic-usage)

### .wslconfig
Windows 빌드 19041 이상에서 WSL 환경 전역 옵션 구성 지원

- [Configure global options with .wslconfig](https://docs.microsoft.com/en-us/windows/wsl/wsl-config#configure-global-options-with-wslconfig)
- [도커 데스크탑이 사용하는 WSL 리소스 제한하기](https://kdevkr.github.io/limit-resources-docker-desktop-using-wslconfig/)

**C:\Users\<yourUserName>\.wslconfig**
```toml
[wsl2]
memory=1GB
processors=1
swap=0
```

### Install Ubuntu 26.04 LTS (Resolute Raccoon)

```ps
# https://releases.ubuntu.com/resolute/ubuntu-26.04-wsl-amd64.wsl
❯ wsl --install --from-file C:\Users\Mambo\Downloads\ubuntu-26.04-wsl-amd64.wsl
설치 중: C:\Users\Mambo\Downloads\ubuntu-26.04-wsl-amd64.wsl
배포가 설치되었습니다. 'wsl.exe -d Ubuntu-26.04'을(를) 통해 시작할 수 있습니다.
Ubuntu-26.04 시작하는 중...
Provisioning the new WSL instance Ubuntu-26.04
This might take a while...
Create a default Unix user account: mambo
New password:
Retype new password:
passwd: password updated successfully
usermod: no changes
Help improve Ubuntu!
```
