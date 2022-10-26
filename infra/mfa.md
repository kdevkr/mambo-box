## MFA

MFA(Multi Factor Authentication)는 사용자 이름과 비밀번호를 통해 인증하는 방식 이외에 방법으로 추가적인 인증을 수행하는 것을 말한다. TOTP 또는 생체 인증을 통한 2FA 인증은 사용자에게 불편함을 제공하지만 보안적인 관점에서는 필수적인 선택일 수 밖에 없다.

- [다중 인증(MFA)이란 무엇입니까?](https://aws.amazon.com/ko/what-is/mfa/)
- [다중 요소 인증(MFA)이 중요한 이유](https://www.okta.com/kr/identity-101/why-mfa-is-everywhere/)
- [Multi-Factor Authentication (MFA)](https://auth0.com/docs/secure/multi-factor-authentication)

MFA는 한가지 방식으로 인증을 수행하는 경우에 발생할 수 있는 비밀번호 노출에 대한 취약점을 보완하기 위한 방법이며 TOTP를 통한 2FA를 적용한다고해서 완벽하게 보호되는 것은 보장하지 못한다. 사용자에게 불편함을 제공하기 때문에 TOTP 적용을 위한 코드를 여러 사람이 공유하여 더 보안적이지 않은 방식으로 이용되기도 한다.

#### 2FA Examples
- [How To Set Up Multi-Factor Authentication for SSH on Ubuntu 20.04](https://www.digitalocean.com/community/tutorials/how-to-set-up-multi-factor-authentication-for-ssh-on-ubuntu-20-04)
- [Hardening SSH using AWS Bastion and MFA](https://medium.com/kaodim-engineering/hardening-ssh-using-aws-bastion-and-mfa-45d491288872)
- [Two Factor Auth with Spring Security](https://www.baeldung.com/spring-security-two-factor-authentication-with-soft-token)