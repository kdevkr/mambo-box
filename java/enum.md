## Enum

```java
public enum TZ {
    UTC("UTC", "+00:00", 0),
    SEOUL("Asia/Seoul", "+09:00", 9);

    private final String timezone;
    private final String offset;
    private final int value;

    TZ(String timezone, String offset, int value) {
        this.timezone = timezone;
        this.offset = offset;
        this.value = value;
    }

    public TimeZone toTimeZone() {
        return TimeZone.getTimeZone(timezone);
    }

    public String getOffset() {
        return offset;
    }

    public int getValue() {
        return value;
    }
}
```

```java
List<TZ> tzList = List.of(TZ.values());
EnumSet<TZ> tzSet = EnumSet.allOf(TZ.class);
EnumMap<TZ, TZ> tzMap = new EnumMap<>(TZ.class);
tzMap.putAll(EnumUtils.getEnumMap(TZ.class, tz -> tz)); // Apache Commons Lang
```

- [A Guide to Java Enums](https://www.baeldung.com/a-guide-to-java-enums)
- [Attaching Values to Java Enum](https://www.baeldung.com/java-enum-values)
- [Enum Mapping in Spring Boot](https://www.baeldung.com/spring-boot-enum-mapping)
- [Java Enums, JPA and PostgreSQL Enums](https://www.baeldung.com/java-enums-jpa-postgresql)
- [Check if List Contains at Least One Enum](https://www.baeldung.com/java-list-check-enum-presence)
- [How To Serialize and Deserialize Enums with Jackson](https://www.baeldung.com/jackson-serialize-enums)
- [Validations for Enum Types](https://www.baeldung.com/javax-validations-enums)
