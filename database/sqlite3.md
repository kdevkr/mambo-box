## SQLite3
SQLite3는 단일 파일로 저장되는 관계형 데이터베이스로 IoT 디바이스와 같은 클라이언트 애플리케이션에서 주로 사용된다. 표준 SQL 문법을 지원하기 때문에 다양한 언어로 작성된 애플리케이션에서 어려움 없이 사용할 수 있으며 트랜잭션을 위해 [WAL 모드](https://www.sqlite.org/wal.html)를 사용하여 약간의 성능 향상이 가능하나 쓰기 작업 시 데이터베이스 자체가 잠김(Lock) 상태가 되므로 빠른 쓰기 작업이 필요한 경우에는 주의해야한다.

#### 지원하지 않은 기능
- 스토어드 프로시저
- 날짜 유형
- 사용자 및 암호

#### Performance Tips
```
PRAGMA page_size = 65536
PRAGMA cache_size = 10000;
PRAGMA locking_mode = EXCLUSIVE;
PRAGMA synchronous = NORMAL;
PRAGMA journal_mode = WAL;
PRAGMA temp_store = MEMORY;
PRAGMA mmap_size = 30000000000;
```

- [WAL mode](https://sqlite.org/wal.html) (3.7.0+)
- [Shared-Cache Mode](https://sqlite.org/sharedcache.html)

#### Links
- https://devdocs.io/sqlite/
- https://avi.im/blag/2021/fast-sqlite-inserts/
- [Database Speed Comparison](https://www.sqlite.org/speed.html)