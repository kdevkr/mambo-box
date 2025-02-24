## ECS awsvpc MaxENI

EC2 용량 공급자 기반 ECS 클러스터의 awsvpc 네트워크 모드를 사용하는 서비스는 인스턴스 유형에 따라 최대 네트워크 인터페이스에 대한 개수 제한되며 ECS 서비스 계정 설정에서 awsvpcTrunking 옵션을 활성화하는 경우 사용중인 인스턴스에서 ENI에 대한 확장을 지원

```sh
aws ec2 describe-instance-types \
    --filters "Name=instance-type,Values=c6g.*" \
    --query "InstanceTypes[].{ \
        Type: InstanceType, \
        MaxENI: NetworkInfo.MaximumNetworkInterfaces, \
        IPv4addr: NetworkInfo.Ipv4AddressesPerInterface}" \
    --output table

----------------------------------------
|         DescribeInstanceTypes        |
+----------+----------+----------------+
| IPv4addr | MaxENI   |     Type       |
+----------+----------+----------------+
|  50      |  15      |  c6g.16xlarge  |
|  10      |  3       |  c6g.large     |
|  15      |  4       |  c6g.xlarge    |
|  30      |  8       |  c6g.12xlarge  |
|  4       |  2       |  c6g.medium    |
|  50      |  15      |  c6g.metal     |
|  30      |  8       |  c6g.8xlarge   |
|  30      |  8       |  c6g.4xlarge   |
|  15      |  4       |  c6g.2xlarge   |
+----------+----------+----------------+
```
