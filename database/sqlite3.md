## SQLite3

```
PRAGMA page_size = 65536
PRAGMA cache_size = 10000;
PRAGMA locking_mode = EXCLUSIVE;
PRAGMA synchronous = NORMAL;
PRAGMA journal_mode = WAL;
PRAGMA temp_store = MEMORY;
PRAGMA mmap_size = 30000000000;
```
- https://avi.im/blag/2021/fast-sqlite-inserts/

### Performance Tips
- [WAL mode](https://sqlite.org/wal.html) (3.7.0+)
- [Shared-Cache Mode](https://sqlite.org/sharedcache.html)

### Links
- https://devdocs.io/sqlite/
- [Database Speed Comparison](https://www.sqlite.org/speed.html)