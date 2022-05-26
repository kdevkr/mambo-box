## DNS, Domain Name System
도메인 네임 시스템은 사람이 인지할 수 있는 이름으로 통신을 위한 IP 주소를 찾아가기 위해 사용한다. 개발자가 직접 도메인에 대한 DNS 레코드를 정의할 가능성은 적으나 DNS 레코드를 질의하는 방법을 알아두면 좋다. 

- [What is DNS? | How DNS works](https://www.cloudflare.com/learning/dns/what-is-dns/)
- [What is DNS? - Introduction to Domain Name System](https://www.youtube.com/watch?v=e2xLV7pCOLI)

일반적으로 국내에서는 KT, SKT와 같은 ISP 업체의 DNS 서버를 기본적으로 선택하여 사용된다. [8.8.8.8](https://developers.google.com/speed/public-dns/docs/using#addresses) 또는 [1.1.1.1](https://1.1.1.1/dns/)와 같은 글로벌 DNS를 수동으로 설정하여 사용해도 무방하다.

### DNS 도구

- [Google Public DNS](https://dns.google/)
- [DNS Performance Analytics and Comparison](https://www.dnsperf.com/)
- [DiG GUI | DiG Web Interface](https://www.diggui.com/)

```bash
ubuntu@ubuntu:~$ dig naver.com +trace

; <<>> DiG 9.16.1-Ubuntu <<>> naver.com +trace
;; global options: +cmd
.                       6289    IN      NS      h.root-servers.net.
.                       6289    IN      NS      f.root-servers.net.
.                       6289    IN      NS      l.root-servers.net.
.                       6289    IN      NS      g.root-servers.net.
.                       6289    IN      NS      j.root-servers.net.
.                       6289    IN      NS      e.root-servers.net.
.                       6289    IN      NS      i.root-servers.net.
.                       6289    IN      NS      m.root-servers.net.
.                       6289    IN      NS      k.root-servers.net.
.                       6289    IN      NS      c.root-servers.net.
.                       6289    IN      NS      a.root-servers.net.
.                       6289    IN      NS      b.root-servers.net.
.                       6289    IN      NS      d.root-servers.net.
;; Received 262 bytes from 127.0.0.53#53(127.0.0.53) in 0 ms

com.                    172800  IN      NS      e.gtld-servers.net.
com.                    172800  IN      NS      b.gtld-servers.net.
com.                    172800  IN      NS      j.gtld-servers.net.
com.                    172800  IN      NS      m.gtld-servers.net.
com.                    172800  IN      NS      i.gtld-servers.net.
com.                    172800  IN      NS      f.gtld-servers.net.
com.                    172800  IN      NS      a.gtld-servers.net.
com.                    172800  IN      NS      g.gtld-servers.net.
com.                    172800  IN      NS      h.gtld-servers.net.
com.                    172800  IN      NS      l.gtld-servers.net.
com.                    172800  IN      NS      k.gtld-servers.net.
com.                    172800  IN      NS      c.gtld-servers.net.
com.                    172800  IN      NS      d.gtld-servers.net.
com.                    86400   IN      DS      30909 8 2 E2D3C916F6DEEAC73294E8268FB5885044A833FC5459588F4A9184CF C41A5766
com.                    86400   IN      RRSIG   DS 8 1 86400 20220608050000 20220526040000 47671 . U/z96yxHnZx3nwEda11jaJom4DJC7fOBt4zsn8fC5ep60RfzAwMj1q8Y 4E4jRlSI28vFuiamNG2uuMAPO/lEUUYuHtYtNsHXnzBKcaDDVK1B3wCA VzEKAQwfh9knPSaD9vCRFfi7nGJWALJbKO3488gz1uBywWu7YQPDDfPp FB/whBsl7/yQihidbbNTbCfQ/oAd88bAq1eFt9tGSL6Wyf0jwp1aeWMd DuM+HcLjyR/7rtBa4YCKob3XniEn+NoavFuikKFJU1Nie1V83ZRU1Xcs OevXYQgT53P857tldjpEM/Lyp70+XgFMJXLoPCe0MfsMqoabiuIiDxyQ vUA5Mg==
;; Received 1169 bytes from 198.41.0.4#53(a.root-servers.net) in 156 ms

naver.com.              172800  IN      NS      ns2.naver.com.
naver.com.              172800  IN      NS      ns1.naver.com.
naver.com.              172800  IN      NS      e-ns.naver.com.
CK0POJMG874LJREF7EFN8430QVIT8BSM.com. 86400 IN NSEC3 1 1 0 - CK0Q2D6NI4I7EQH8NA30NS61O48UL8G5 NS SOA RRSIG DNSKEY NSEC3PARAM
CK0POJMG874LJREF7EFN8430QVIT8BSM.com. 86400 IN RRSIG NSEC3 8 2 86400 20220530082513 20220523071513 37269 com. rGFmb7KWfFWLa2wdegU/hcqoDHxSKwJUkbj6DMSYfkHrwKot/T2EROZQ RF5KJtD3Ae6u7xRPIqGft5rvKOPQD40klXtYrMmMv23rCwXaHjGkdtez HLFl8//cjwFArN7MQZlUdGqDiFDHRIFP7gj9vJ/f+E9wrZs5zmsGy/We J+5hwjAyDh+GDCvNxTnJcmsRGOVJsdPmSlL7KrTiWOMRBA==
6P7FFO8EEM58RPICB5T469F3QR5KCAQ2.com. 86400 IN NSEC3 1 1 0 - 6P7FJSB17Q1NHQK3OTKO6KN3TPCVB2VQ NS DS RRSIG
6P7FFO8EEM58RPICB5T469F3QR5KCAQ2.com. 86400 IN RRSIG NSEC3 8 2 86400 20220530044739 20220523033739 37269 com. X3H/9eali1v8QxOJUTXXt3K0tFauYhZN1pzoiWLOvrJ5alYgvVj9khzb C7tY2j+mEeWKKpJ13S+LG7pYf0iCEf95KEkf/Dog+h2IKnXlS32mv4j6 Gw8ilPda1fp5uJaCOxAKGjdMzyOv7Z3nPUfGhuxdGv6GPz50RWvtQi4P 9iqCXaisggRLGPRM1gp3VrcVInUUApu0BWlEhQKgfyR8gQ==
;; Received 690 bytes from 192.55.83.30#53(m.gtld-servers.net) in 134 ms

naver.com.              300     IN      A       223.130.200.104
naver.com.              300     IN      A       223.130.200.107
naver.com.              300     IN      A       223.130.195.200
naver.com.              300     IN      A       223.130.195.95
;; Received 102 bytes from 125.209.248.6#53(ns1.naver.com) in 4 ms
```