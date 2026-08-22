# Have I Been Pwned? (HIBP) - Passwords

[Have I Been Pwned? Passwords](https://haveibeenpwned.com/Passwords)는 데이터 유출 사고(Data Breach)를 통해 대중에 노출된 적이 있는 비밀번호인지를 안전하게 조회할 수 있는 서비스 및 API입니다.

## 1. 개요
* **목적**: 사용자가 설정하려는 비밀번호가 이미 유출된 적이 있어 사전 공격(Dictionary Attack)이나 자격 증명 스터핑(Credential Stuffing) 공격에 취약한지 검증합니다.
* **보안성 (k-Anonymity 모델)**: 비밀번호 원문이나 전체 해시값을 서버로 전송하지 않고, 비밀번호의 SHA-1 해시값 앞 5자리(Prefix)만 전송하여 일치하는 후보군 목록을 받아온 뒤 클라이언트 측에서 나머지 35자리(Suffix)를 비교하는 안전한 방식으로 작동합니다.

## 2. 주요 활용법
* **회원가입/비밀번호 변경 시 검증**: 사용자가 새로운 비밀번호를 설정할 때, HIBP API를 호출하여 유출 이력이 있는 비밀번호인 경우 다른 비밀번호를 설정하도록 안내합니다.
* **NIST 디지털 가이드라인 준수**: NIST SP 800-63B에서는 이전에 유출된 적이 있는 비밀번호의 사용을 제한할 것을 권고하고 있으며, HIBP가 이에 대한 대표적인 검증 수단으로 활용됩니다.

## 3. Spring Security 연동 (Compromised Password Check)
Spring Security 6.3에서 유출된 비밀번호 사용을 제한하기 위한 내장 컴포넌트로 `HaveIBeenPwnedRestApiPasswordChecker`가 새롭게 도입되었습니다. 이 체커는 HIBP API를 활용하여 사용자가 입력한 비밀번호의 위협 여부를 간편하게 검증합니다.

### 설정 예시 (Java Config)
```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

@Configuration
public class SecurityConfig {

    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker() {
        // 기본적으로 Have I Been Pwned REST API를 사용하여 유출 여부를 조회합니다.
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }
}
```

* **동작 방식 및 활용**: 
  * **자동 예외 처리**: 로그인 또는 회원가입 단계에서 사용자가 입력한 비밀번호의 유출 여부를 자동으로 조회하고, 유출된 비밀번호인 경우 `CompromisedPasswordException`을 발생시켜 요청을 차단할 수 있습니다.
  * **사용자 피드백 및 취약성 정보 제공**: 개발자는 `CompromisedPasswordChecker`를 빈으로 주입받아 직접 비밀번호 검증 로직에 활용할 수 있습니다. 검증 메소드인 `check(password)`는 `CompromisedPasswordDecision`을 반환하며, 이를 통해 비밀번호의 유출 여부뿐만 아니라 **구체적인 유출 횟수** 정보를 획득하여 사용자에게 직관적인 경고 피드백을 제공할 수 있습니다.

### 사용자 피드백 구현 예시
```java
CompromisedPasswordDecision decision = compromisedPasswordChecker.check(rawPassword);
if (decision.isCompromised()) {
    // decision.isCompromised()가 true인 경우 유출된 적이 있는 취약한 비밀번호입니다.
    log.warn("입력한 비밀번호는 노출된 이력이 있습니다.");
    
    // 필요에 따라 사용자에게 노출 빈도 등의 피드백을 제공하여 보안 경각심을 높일 수 있습니다.
}
```


## 4. 관련 자료 및 도구
* **공식 웹사이트**: [haveibeenpwned.com/Passwords](https://haveibeenpwned.com/Passwords)
* **API 문서**: [HIBP Pwned Passwords API Reference](https://haveibeenpwned.com/API/v3#PwnedPasswords)
* **Spring Security 공식 문서**: [Compromised Password Check](https://docs.spring.io/spring-security/reference/features/authentication/password-storage.html#authentication-compromised-password-check)

