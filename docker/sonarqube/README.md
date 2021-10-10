## SonarQube

- [SonarQube Community Edition](https://hub.docker.com/_/sonarqube)
- [Gradle Jacoco Plugin](https://docs.gradle.org/current/userguide/jacoco_plugin.html)
- [SonarQube GitHub Action Plugin](https://github.com/kitabisa/sonarqube-action)

### SonarQube Community Edition 서버 구축
현재 폴더의 docker-compose.yml를 참고하여 SonarQube Community Edition 서버를 구축한다.

### Gradle Jacoco Plugin 적용
현재 폴더의 build.gradle을 참고하여 test 태스크 수행 시 Jacoco 리포트 파일이 생성되도록 설정한다.

- build/jacoco/test.exec
- build/reports/jacoco/test/jacocoTestReport.xml

### SonarQube Github Action Plugin 워크플로우 정의
.github/workflows 폴더의 sonarqube.yml을 참고하여 SonarQube 워크플로우를 정의한다.

### TroubleShooting

#### WSL vm.max_map_count 설정하기

윈도우에서 WSL을 사용하여 소나큐브 도커 컨테이너를 실행하는 경우 WSL의 vm.max_map_count를 설정해야한다. Elasticsearch 실행 시 vm.max_map_count이 262144 설정되어야한다.

[vm.max_map_count in docker-desktop distro for WSL2](https://github.com/docker/for-win/issues/5202#issuecomment-585498457)

```sh
# Max virtual memory areas vm.max_map_count [65530] is too low, increase to at least [262144]
wsl -d docker-desktop
sysctl -w vm.max_map_count=262144
```



