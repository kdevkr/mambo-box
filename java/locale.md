## Locale 문자열 변환

문자열에서 로케일(Locale) 객체로 변환할 때의 주의점과 유틸 함수 정리.

### Locale.forLanguageTag

`java
Locale.forLanguageTag("ko_KR"); // → ""
Locale.forLanguageTag("ko_KR".replace("_", "-")); // → ko_KR
`

Locale.forLanguageTag 함수에 ko_KR과 같이 언더스코어(_)가 포함된 문자열을 전달하면 예외가 발생하지 않고 **비어있는 Locale**이 생성된다. 따라서 언더스코어를 하이픈(-)으로 변환하여 전달해야 한다.

### LocaleUtils 및 StringUtils

스프링 프레임워크 또는 Apache Commons의 유틸리티를 활용할 수도 있다.

`java
org.apache.commons.lang3.LocaleUtils.toLocale("ko_KR");
org.springframework.util.StringUtils.parseLocale("ko_KR");
`
