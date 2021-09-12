<div style="text-align: center;"><img src="images/docker-logo.png" width="50%" /></div>

# 도커
도커는 애플리케이션을 실행할 수 있는 환경을 만들어주는 **가상의 경량화 컨테이너 기술**이다.

## 도커란 무엇인가
도커에 대해서 자세히 알고싶다면 다음의 글들을 참고해보자.

- [초보를 위한 도커 안내서 - 도커란 무엇인가?](https://subicura.com/2017/01/19/docker-guide-for-beginners-1.html)
- [컨테이너 기초부터 서버 배포까지](https://www.44bits.io/ko/post/easy-deploy-with-docker)  
- [만들면서 이해하는 도커(Docker) 이미지의 구조](https://www.44bits.io/ko/post/how-docker-image-work)  
- [Docker Curriculum](https://docker-curriculum.com/)

## 도커 명령어

### 도커 컨테이너 인터랙티브 쉘
```sh
# docker exec -it [container_name] [shell]
docker exec -it postgres /bin/bash

# docker-compose [service_name] [shell]
docker-compose postgres /bin/bash
```

## 도커 이미지
애플리케이션을 실행하기 위한 환경을 이미지로 구성한 것을 **도커 이미지**라고 한다. 도커 이미지는 [Dockerfile](https://docs.docker.com/engine/reference/builder/) 이라고하는 파일에 명령어 집합을 작성하여 만들 수 있다.

### 도커 빌드 명령어
```sh
docker build .
```

도커 데몬 프로세스에 현재 컨텍스트(디렉토리)에 대한 모든 파일이 전송되므로 [.dockerignore](https://docs.docker.com/engine/reference/builder/#dockerignore-file) 파일을 통해 불필요한 파일을 가져가지 않도록 하는 것이 좋다.

### 도커 이미지 최적화
도커 이미지를 만들다보면 생각보다 큰 이미지 사이즈를 가질 수 있다. 
FROM, ADD, COPY, RUN 명령들은 컨테이너 이미지 레이어를 구성하기 때문에 이미지 사이즈가 결정되는 중요한 부분이니 신경써서 작성해야 한다.

도커 이미지 사이즈를 최적화하고 싶다면 다음의 글들을 참고해보자.

- [Best practices for writing Dockerfiles](https://docs.docker.com/develop/develop-images/dockerfile_best-practices/)  
- [도커 이미지 잘 만드는 방법](https://jonnung.dev/docker/2020/04/08/optimizing-docker-images/)  
- [Windows Dockerfile 최적화](https://docs.microsoft.com/ko-kr/virtualization/windowscontainers/manage-docker/optimize-windows-dockerfile)  

## 도커 엔진
도커는 `dockerd` 라고하는 데몬 프로세스로 구동되는 [도커 엔진(dockerd)](https://docs.docker.com/engine/)과 도커 엔진과 통신하는 도커 CLI로 구성된다. 

docker version 명령어를 수행하면 다음과 같이 도커 엔진과 CLI 버전이 표기된다.
```ps Windows Terminal
PS C:\Users\Mambo> docker version
Client:
 Cloud integration: 1.0.17
 Version:           20.10.8
 API version:       1.41
 Go version:        go1.16.6
 Git commit:        3967b7d
 Built:             Fri Jul 30 19:58:50 2021
 OS/Arch:           windows/amd64
 Context:           default
 Experimental:      true

Server: Docker Engine - Community
 Engine:
  Version:          20.10.8
  API version:      1.41 (minimum version 1.12)
  Go version:       go1.16.6
  Git commit:       75249d8
  Built:            Fri Jul 30 19:52:10 2021
  OS/Arch:          linux/amd64
  Experimental:     false
 containerd:
  Version:          1.4.9
  GitCommit:        e25210fe30a0a703442421b0f60afac609f950a3
 runc:
  Version:          1.0.1
  GitCommit:        v1.0.1-0-g4144b63
 docker-init:
  Version:          0.19.0
  GitCommit:        de40ad0
```

### 도커 데스크탑
윈도우 또는 Mac에서는 도커 엔진, 도커 CLI, 크레덴셜 헬퍼등이 포함된 도커 데스크탑을 제공한다. 윈도우에서는 WLS 2 Backend 기능을 통해 리눅스 시스템에서 컨테이너가 실행되도록 지원한다.

- [Install Docker Desktop on Windows](https://docs.docker.com/desktop/windows/install/)
- [Install Docker Desktop on Mac](https://docs.docker.com/desktop/mac/install/)

> M1 칩셋 기반의 맥의 경우 로제타를 설치하여야 한다.

### 리눅스 배포판

- [리눅스 배포판 도커 엔진 설치](install-on-distro)


## 도커 레지스트리
보안 등급이 높은 회사에서는 자체적으로 프라이빗 도커 레지스트리를 구축하여 사용한다.

```sh
docker run --entrypoint htpasswd registry:2 -Bbn $username $password > auth/htpasswd
```

```yaml docker-compose.yml
version: '3.8'
services:
    registry:
        image: registry:2.7
        restart: always
        ports:
            - 5000:5000
        environment:
            REGISTRY_HTTP_TLS_CERTIFICATE: /certs/server-ca-bundle.crt
            REGISTRY_HTTP_TLS_KEY: /certs/server.key
            REGISTRY_AUTH: htpasswd
            REGISTRY_AUTH_HTPASSWD_PATH: /auth/htpasswd
            REGISTRY_AUTH_HTPASSWD_REALM: Registry Realm
            REGISTRY_STORAGE: s3
            REGISTRY_STORAGE_S3_BUCKET: mambo-registry
            REGISTRY_STORAGE_S3_ACCESSKEY: accesskey
            REGISTRY_STORAGE_S3_SECRETKEY: secretkey
            REGISTRY_STORAGE_S3_REGION: ap-northeast-2
        volumes:
            - ./certs:/certs
            - ./auth:/auth
```

## 도커 컴포즈
[도커 컴포즈](https://github.com/docker/compose)는 [컴포즈 스펙](https://www.compose-spec.io/)를 기반으로 도커 그룹에서 개발하는 컴포즈 구현체이다.

- [Awesome Compose](https://awesome-docker.netlify.app)