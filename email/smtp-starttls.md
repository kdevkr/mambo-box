## SMTP STARTTLS Command

기능|사용하는 포트|설명
---|---|---
SMTP over TLS (Implicit TLS)|465|RFC 8314 이후로 다시 명시적 암호화 권장
SMTP with STARTTLS|587|465 포트 폐기로 587 포트로 전환 유도되었음

- `STARTTLS` 확장은 [Opportunistic TLS](https://en.wikipedia.org/wiki/Opportunistic_TLS)에 해당한다.
- 예전에는 465 포트 폐기로 인해 587 포트로 전환이 유도되었다.
- 이제는 다시 `STARTTLS` 보다는 `명시적 TLS 연결(465 포트)`을 권장한다.
