## 인텔리제이 젠킨스 플러그인 연동 방법

#### 1. 젠킨스 플러그인 설치
![001](https://user-images.githubusercontent.com/17937604/219660379-3e5eafbd-5cf9-488a-8111-d7d55950bba7.png)

#### 2. 젠킨스 사용자 API 토큰 및 Crumb 발급
![002](https://user-images.githubusercontent.com/17937604/219660768-c7c36c09-3f55-4806-90d0-7c55a0f2824e.png)

젠킨스 사용자 로그인 후 `/crumbIssuer/api/json?tree=crumb` 엔드포인트를 통해 외부 접근 시 CSRF를 위한 Crumb 발급이 가능하다.

#### 3. API 토큰 및 Crumb 설정 후 연결 테스트
![003](https://user-images.githubusercontent.com/17937604/219660398-b631a848-115f-44f5-a209-969737bb5252.png)

젠킨스 사용자에 대한 비밀번호가 아닌 API 토큰을 발급하고나서 연결 테스트를 수행할 수 있다.

## 참고 링크 
- https://github.com/MCMicS/jenkins-control-plugin/issues/123#issuecomment-643127166
