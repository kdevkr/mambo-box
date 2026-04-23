# IANA TimeZone
- https://www.iana.org/time-zones
- https://timeapi.io/documentation/iana-timezones

## Summary
- 전 세계의 시간대 정보를 체계적으로 정리한 표준 데이터베이스
- 컴퓨터 프로그래밍과 운영체제에서 표준으로 사용
- 예: Asia/Seoul, Aisa/Tokyo, America/New_York, Europe/Paris
- UTC Offset: 협정 세계시(UTC)를 기준으로 특정 지역의 표준시가 얼마나 앞서거나 뒤쳐져 있는지를 나타내는 시간 차이
- ISO 8601: 날짜와 시간을 표기하는 국제 표준 형식
- 자바와 DB 버전에 따른 타임존 목록이 다를 수 있음

## Example

### Java support timezones
```java
Set<String> allZones = new TreeSet<>(ZoneId.getAvailableZoneIds());
```

### PostgreSQL support timezones
```sql
SELECT name, abbrev, utc_offset, is_dst
FROM pg_timezone_names
ORDER BY name;
```

### Linux support timezones
```sh
timedatectl list-timezones
ls /usr/share/zoneinfo # file based
```

### Python support timezones
```py
import zoneinfo
tz_list = sorted(zoneinfo.available_timezones())
```
