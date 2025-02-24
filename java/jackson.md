## Jackson ObjectMapper

### StreamReadConstraints.maxStringLength

ObjectMapper에서 처리할 수 있는 최대 크기 제한을 변경

```java
@Configuration
public class JsonConfig {
    static {
        // NOTE: StreamReadConstraints.maxStringLength 확장
        StreamReadConstraints.overrideDefaultStreamReadConstraints(
            StreamReadConstraints.builder()
                .maxStringLength((int) DataSize.ofMegabytes(50L).toBytes())
                .build()
        );
    }
}
```

- [애플리케이션 전역 설정](https://github.com/spring-projects/spring-boot/issues/34709#issuecomment-1593441991)
- [스프링 부트 ObjectMapper 설정](https://github.com/spring-projects/spring-boot/issues/34709#issuecomment-1482939940)
