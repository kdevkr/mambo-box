# ClickHouse

[The fastest OLAP Database.](https://clickhouse.com/)

```groovy
implementation("com.clickhouse:clickhouse-jdbc:0.9.1:shaded-all")
```
- [ClickHouse Java Client 공식 문서 (한국어)](https://clickhouse.com/docs/ko/integrations/language-clients/java/client)
- [ClickHouse Java Clients & JDBC Driver (GitHub)](https://github.com/ClickHouse/clickhouse-java)
- [Introduction to ClickHouse Database](https://www.baeldung.com/spring-boot-olap-clickhouse-database)
- 데이터 업데이트 및 수동 삭제 불가
- [Sentry backed by ClickHouse](https://sentry.engineering/blog/how-sentry-queries-unstructured-data-in-clickhouse-62x-faster)

## Docker 실행 (Local)
이 프로젝트의 Docker 스택을 사용하여 ClickHouse를 실행할 수 있습니다.
- [Docker Compose 설정](../docker/clickhouse/compose.yml)
- [Docker 실행 가이드](../docker/clickhouse/README.md)

| 구분 | 정보 |
| :--- | :--- |
| **HTTP Port** | `8123` |
| **User / Password** | `default` / `mambo` |
