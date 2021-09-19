# 아마존 웹 서비스로 배우는 IT 인프라

- [[AWS] 가장쉽게 VPC 개념잡기](https://medium.com/harrythegreat/aws-%EA%B0%80%EC%9E%A5%EC%89%BD%EA%B2%8C-vpc-%EA%B0%9C%EB%85%90%EC%9E%A1%EA%B8%B0-71eef95a7098)
- [만들면서 배우는 아마존 버추얼 프라이빗 클라우드(Amazon VPC)](https://www.44bits.io/ko/post/understanding_aws_vpc)

## 네트워크 환경 구성
아마존 웹 서비스는 IT 인프라 구성을 위한 다양한 서비스를 제공한다. VPC(Virtual Private Cloud)는 가상의 네트워크 환경을 구축하는 서비스이다.

### 리전과 가용 영역
많은 클라우드 서비스는 클러스터링된 데이터 센터를 지역적으로 구분되는 리전 단위로 서비스를 제공한다.

[리전 맵 및 엣지 네트워크](https://aws.amazon.com/ko/about-aws/global-infrastructure/regions_az/)  

- 2016년 9월 전세계 13개의 리전 지원
- 2021년 9월 전세계 25개의 리전 + 7개 추가 예정

하나의 리전에는 2개 이상의 가용 영역이라고 하는 데이터 센터가 존재할 수 있으며 서울 리전의 경우 [4개의 가용 영역](https://aws.amazon.com/ko/blogs/korea/now-open-fourth-availability-zone-in-the-aws-asia-pacific-seoul-region/)을 지원하고 있다.

여러개의 가용 영역을 통해 정전 또는 낙뢰와 같은 천재지변으로 발생하는 장애에 대해 높은 가용성을 보여주지만 2011년 9월에 발생한 [대규모 정전 사태](https://www.youtube.com/watch?v=YU8l0XBggRM)와 같은 블랙아웃 상황에서는 높은 가용성의 의미는 없을 수 있다는 것은 알아야 한다.

가용 영역에 대한 안정성에 대하여 더 자세하게 알고 싶다면 [가용 영역을 사용한 정적 안정성](https://aws.amazon.com/ko/builders-library/static-stability-using-availability-zones/)을 확인하자.

### 프라이빗 네트워크 주소 할당  
가상의 네트워크 환경인 VPC 내에서 사용하기 위한 프라이빗 네트워크 주소 범위는 RFC1918에 정의된 사설 네트워크를 위한 주소 범위를 사용하는 것을 권장한다. 

- 10.0.0.0/8
- 172.16.0.0/12
- 192.168.0.0/16

RFC1918의 사설 네트워크 주소 범위 중 하나의 VPC에서 사용가능한 네트워크 주소의 [CIDR 블록](https://datatracker.ietf.org/doc/html/rfc4632)은 16비트의 넷마스크부터 28비트의 넷마스크까지 최대 65536개의 IP를 할당할 수 있도록 지원한다. 그리고 고가용성을 위해 VPC 내에 더 좁은 범위의 네트워크 주소 범위인 서브넷을 다수의 가용 영역에 할당한다.

### 퍼블릭 서브넷
프라이빗 네트워크 주소를 사용하는 VPC에서 인터넷에 접속하기 위해서는 인터넷 게이트웨이(IGW)를 연결해야하며 인터넷 게이트웨이를 통해 인터넷 접속이 가능하도록 라우팅 테이블이 설정된 서브넷을 퍼블릭 서브넷이라고 한다.

[VPC 생성하기](create-vpc.md)를 통해 VPC 인프라 구성을 따라해볼 수 있다.

