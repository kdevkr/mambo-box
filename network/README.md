# 네트워크

## 프라이빗 네트워크

### 인터넷 표준 RFC1918 서브넷
[RFC1918](https://datatracker.ietf.org/doc/html/rfc1918)로 정의된 프라이빗 인터넷 주소 할당

```sh
10.0.0.0        -   10.255.255.255  (10/8 prefix)
172.16.0.0      -   172.31.255.255  (172.16/12 prefix)
192.168.0.0     -   192.168.255.255 (192.168/16 prefix)
```

- A 클래스(10.0.0.0/8)는 24비트 블록
- B 클래스(172.16.0.0/12)는 20비트 블록
- C 클래스(192.168.0.0/16)는 16비트 블록

[![s](http://img.youtube.com/vi/R1UWYQYTPKo/0.jpg)](https://youtu.be/R1UWYQYTPKo?t=453)

## 참고
- [RFC1918](https://datatracker.ietf.org/doc/html/rfc1918)
- [IPv4 / IPv6 CIDR 계산기](https://ko.rakko.tools/tools/27/)