# 자체 서명 인증서 - 맥

## 사설 루트 CA 인증서 등록하는 방법

### 1. 시스템 키 체인에서 인증서 관리

#### 1.1 Mac용 키체인 접근을 사용하여 키체인에 인증서 추가하기
루트 CA 인증서 파일을 키 체인 앱으로 드래그 - https://support.apple.com/ko-kr/guide/keychain-access/kyca2431/mac

#### 1.2 명령어 기반 인증서 등록
```sh
sudo security add-trusted-cert -d -r trustRoot -k /Library/Keychains/System.keychain ./localCA.crt
```
