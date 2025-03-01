## AWS IoT Core

IoT 디바이스를 AWS 클라우드에 연결하여 데이터를 수집하기 위한 관리형 서비스

### 컨트롤 플레인 엔드포인트(Control Plane Endpoint)

```sh
aws iot describe-endpoint
```

- IoT 디바이스에 대한 사물 및 인증서, 보안 정책을 관리
- 디바이스에 대한 인증서를 발급하고 회수(파기)하는 작업을 수행

### IoT 디바이스 엔드포인트(IoT Device Endpoint)

```sh
aws iot describe-endpoint --endpoint-type iot:Data-ATS
```

- AWS 클라우드에 연결하여 데이터를 보내고 수신하는 데이터 영역 엔드포인트
- `Data-ATS`는 [ATS(Amazon Trust Services CA)](https://www.amazontrust.com/repository/)로 검증되는 디바이스 엔드포인트
- X.509 인증서와 MQTT 프로토콜을 활용하는 디바이스는 Data-ATS 엔드포인트를 사용 ([디바이스 통신 프로토콜](https://docs.aws.amazon.com/ko_kr/iot/latest/developerguide/protocols.html))
- MQTT Weboscket을 활용하는 디바이스는 X.509 인증서가 아닌 `SigV4` 서명으로 인증
