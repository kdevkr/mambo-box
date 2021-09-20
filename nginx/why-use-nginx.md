## Nginx를 사용하는 이유
애플리케이션 서버와 함께 Nginx를 사용하는 주된 이유는 다음과 같다.

1. Reverse Proxy
2. SSL/TLS Termination
3. Load Balancing
4. Failover for HA(High Availablity)
5. Serving Static Content

### Reverse Proxy
리버스 프록시(Reverse Proxy)는 클라이언트에서 보낸 요청을 처리할 수 있는 서버로 요청 정보를 전달하는 게이트웨이 역할을 수행하는 것이다. 리버스 프록시를 구성하면 애플리케이션 서버가 실행되는 포트를 외부와 단절시킬 수 있으며 웹 요청에 대하여 사후처리를 진행하여 잘못된 요청이 애플리케이션 서버로 전달되지 않도록 방지할 수 있다.

여기서 사후처리라함은 웹 요청을 전달한 클라이언트의 주소를 전달하는 [Forwarded](https://developer.mozilla.org/ko/docs/Web/HTTP/Headers/Forwarded) 관련 헤더를 요청 정보에 추가하거나 애플리케이션으로부터 받은 응답을 압축하는 것등을 말한다.

```nginx
upstream backend {
    server 172.31.0.123:8080;
}

location / {
    proxy_pass http://backend
    # Default Proxy Settings
    proxy_http_version 1.1;
    proxy_buffering off;
    proxy_set_header Host $http_host;
    proxy_set_header Upgrade $http_upgrade;
    proxy_set_header Connection $proxy_connection;
    proxy_set_header X-Real-IP $remote_addr;
    proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
    proxy_set_header X-Forwarded-Proto $proxy_x_forwarded_proto;
    proxy_set_header X-Forwarded-Ssl $proxy_x_forwarded_ssl;
    proxy_set_header X-Forwarded-Port $proxy_x_forwarded_port;
}
```

> 아마존 웹 서비스의 Elastic Beanstalk 환경에서는 리버시 프록시 구성을 위해서 Nginx를 기본 웹 서버로 제공한다.

### SSL/TLS Termination
리버스 프록시를 구성함으로써 적용할 수 있는 주요 사후처리 중 하나는 HTTPS 연결 시 수행하는 TLS 핸드쉐이크를 담당하도록 [SSL/TLS Termination](https://docs.nginx.com/nginx/admin-guide/security-controls/terminating-ssl-http/)을 구성할 수 있다. 애플리케이션 서버는 HTTPS 연결을 위한 SSL 인증서 관리를 하지 않으며 TLS 핸드쉐이크에 대한 부하를 담당하지 않아도 된다.

```nginx
server {
    listen              443 ssl;
    server_name         www.example.com;
    ssl_certificate     www.example.com.crt;
    ssl_certificate_key www.example.com.key;
    ssl_protocols       TLSv1.2 TLSv1.3;
    ssl_ciphers         HIGH:!aNULL:!MD5;
}
```

> 웹 서버에서 TLS 협상을 수행하므로 애플리케이션 서버에서 다양한 TLS 버전을 지원하지 않아도 무방하다.

### Load Balancing
리버스 프록시를 구성하여 애플리케이션 서버에 대한 정보를 감춤으로써 웹 요청을 실제로 처리하는 다수의 애플리케이션 서버를 구성하여 여러가지 알고리즘에 의해 웹 요청을 분산시키는 [로드 밸런싱(Load Balancing)](https://docs.nginx.com/nginx/admin-guide/load-balancer/http-load-balancer/)을 적용할 수 있다.

```nginx
upstream backend {
    server 172.31.0.123:8080;
    server 172.31.1.124:8080;
    server 172.31.2.125:8080;
}
```

### Failover for HA
정전과 같은 예기치 못한 장애에 대비할 수 있도록 Failover를 구성할 수 있도록 지원한다. 

```nginx
upstream backend {
    server 172.31.0.123:8080 fail_timeout=10s max_fails=3;
    server 172.31.1.124:8080 backup;
}
```

> 더 확실한 Failover 기능을 사용하기 위해서는 Nginx 플러스를 사용해야한다.

### Serving Static Content
Nginx는 [정적 파일을 배포](https://docs.nginx.com/nginx/admin-guide/web-server/serving-static-content/)하기 위한 웹 서버이다. 애플리케이션 서버에서 제공하던 스크립트와 CSS 그리고 이미지와 같은 에셋 파일들을 Nginx가 대신하여 배포해줌으로써 애플리케이션 서버에 전달되는 요청 트래픽이 많아질 때 정적 파일을 제공하기 위한 부담을 줄일 수 있다.

```nginx
server {
    location /images/ {
        root /var/app/images/;
        autoindex off;
    }
}
```

