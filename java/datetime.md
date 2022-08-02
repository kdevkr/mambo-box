## Datetime

```java
public class Main {
    public static void main(String[] args) throws Exception {
        TimeZone tzSeoul = TimeZone.getTimeZone("Asia/Seoul");
        DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
                .appendPattern("[yyyy-MM-dd HH:mm:ss]")
                .appendPattern("[yyyy-MM-dd HH:mm]")
                .appendPattern("[yyyy-MM-dd]")
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .toFormatter()
                .withZone(tzSeoul.toZoneId());

        String[] dateStrArr = new String[]{"2022-03-19 00:00:00", "2022-03-19 00:00", "2022-03-19"};

        for (String dateStr : dateStrArr) {
            ZonedDateTime dateTime = ZonedDateTime.parse(dateStr, dateTimeFormatter);
            System.out.printf("%s -> %s%n", dateStr, dateTime);
        }
    }
}
```