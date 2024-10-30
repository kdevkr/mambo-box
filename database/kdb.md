# KDB

- 고성능 컬럼형 시계열 데이터베이스
- 인메모리 컴퓨팅 엔진 및 실시간 스트리밍 처리

## Install
- https://code.kx.com/q/learn/install
- 라이센스 관련 k4.lic 또는 kc.lic 파일을 요구

## Run as
```sh
taskset -c 0,1 q -p 5000 -s 8
```

## Terminate

- exit 명령어 또는 슬래시 두개를 입력하여 종료.
- 원격 통신에 의한 호출도 허용되므로 주의.

```q
\\
exit 0
```

## Iterators
> https://code.kx.com/q/wp/iterators/

```q
/ Each
/ {select from trade where date = x} each dates;
{select from trade where date = x}'[dates];

/ Each Parallel
/ {select from trade where date = x} peach dates;
{select from trade where date = x}':[dates];

/ Each joins
rdb:4!trade from realtime;
hdb:4!trade from historical;
cdb:0#rdb;
cdb,:hdb,rdb;
```

## References

- [kdb+tick](https://github.com/KxSystems/kdb-tick)
- [javakdb](https://github.com/KxSystems/javakdb)
- [PyQ - Python for kdb+](https://github.com/KxSystems/pyq)
- [What Makes Time-Series Database kdb+ So Fast?](https://kx.com/blog/what-makes-time-series-database-kdb-so-fast/)
- [Partitioning Data in kdb+](https://kx.com/blog/partitioning-data-in-kdb/)
- [Reference architecture for AWS](https://code.kx.com/q/cloud/aws/)
- [Kdb+ Version 4.0 – Faster, More Secure](https://kx.com/blog/kdb-version-4-0-faster-more-secure/)
- [Discover kdb+ 4.1’s New Features](https://kx.com/blog/discover-kdb-4-1s-new-features/)
