## TimescaleDB
PostgreSQL(관계형 데이터베이스)를 기반으로 시계열 데이터베이스로 확장한 솔루션이며 관계형 데이터베이스인 PostgreSQL에 대한 특징을 기본적으로 알아야하며 라이센스 개념 상 AWS RDS와 같은 일부 클라우드 서비스에서 지원하지 않는다. 셀프 호스팅이나 도커 그리고 AWS AMI 이미지를 제공해서 여러가지 방식으로 설치할 수 있는 가이드를 제공한다.

> [Timescale Cloud](https://www.timescale.com/cloud/)를 처음 사용하는 사용자라면 30일 간 무료 플랜을 제공하므로 원하는 만큼 최대한 학습할 수 있는 환경을 제공해준다. 단, 30일 이후에 비용이 지불되지 않도록 학습을 완료했다면 생성했던 서비스를 반드시 종료해야한다.

### Installation
개인적으로 셀프 호스팅 방식은 [도커 이미지로 설치](https://docs.timescale.com/install/latest/installation-docker/)하는 것을 추천하며 AWS 환경을 사용중이라면 [Ubuntu 20.04 Amazon EBS-backed AMI](https://docs.timescale.com/install/latest/installation-cloud-image/)로 구성하는 것을 추천한다.

### Features
- PostgreSQL 11+
- [Hypertable (Time Partitioning)](https://docs.timescale.com/timescaledb/latest/how-to-guides/hypertables/)
- [Continuous aggregates](https://docs.timescale.com/timescaledb/latest/how-to-guides/continuous-aggregates/)
- [VACCUM](https://docs.timescale.com/timescaledb/latest/how-to-guides/write-data/delete/)
- [Gap filling](https://docs.timescale.com/timescaledb/latest/how-to-guides/query-data/advanced-analytic-queries/#fill-gaps-in-time-series-data)

자세한 내용은 [Tutorials](https://docs.timescale.com/timescaledb/latest/tutorials/)을 통해 학습할 수 있게 다양한 문서를 제공한다.

