# Nginx

엔진엑스(Nginx)는 웹서버임에도 불구하고 HAProxy와 더불어 많은 기업에서 사용하는 로드 밸런싱 도구이다. 아마존 웹 서비스의 Elastic Beanstalk의 경우 Nginx의 [역방향 프록시를 구성](https://docs.aws.amazon.com/ko_kr/elasticbeanstalk/latest/dg/java-se-nginx.html)하여 ELB와 연결한다. 

> [HAProxy](http://www.haproxy.org/)는 엔진엑스와 더불어 많이 사용되는 로드 밸런서이다.

## Reverse Proxy
유닉스 계열의 운영체제에서 80 포트와 같은 잘 알려진 포트는 루트 권한으로 사용할 수 있어 애플리케이션 운영 시 HTTP 트래픽을 처리하기 위하여 루트 권한의 웹 서버를 통해 애플리케이션으로 웹 요청 트래픽을 전달할 수 있도록 프록시를 구성하여 리버스 프록시를 수행한다.

## Configuration

```conf
# /etc/nginx/nginx.conf
worker_processes    auto;
worker_rlimit_nofile 2048; # worker_connections * 2 file descriptors
multi_accept    on;
use             epoll;

events {
  worker_connections  1024;
}

http {
    ssl_session_cache       shared:SSL:5m;
    ssl_session_timeout     5m;

    server {
        listen                      443 ssl http2;
        server_name                 www.example.com;
        ssl_certificate             server.crt;
        ssl_certificate_key         private.key;
        ssl_protocols               TLSv1.2 TLSv1.3;
        ssl_ciphers                 HIGH:!aNULL:!MD5;
        ssl_prefer_server_ciphers   on;
    }
}
```


## 관련 문서  
- [How To Use the Official NGINX Docker Image](https://www.docker.com/blog/how-to-use-the-official-nginx-docker-image/)  
- [NGINX - Full Example Configuration](https://www.nginx.com/resources/wiki/start/topics/examples/full/)  
- [NGINX Tuning For Best Performance](https://github.com/denji/nginx-tuning)  
- [Why Netflix Chose NGINX as the Heart of Its CDN](https://www.nginx.com/blog/why-netflix-chose-nginx-as-the-heart-of-its-cdn/)