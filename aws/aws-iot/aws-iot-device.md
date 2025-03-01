## AWS IoT Device

IoT 디바이스는 [AWS Iot Device SDK](https://github.com/aws/aws-iot-device-sdk-java-v2)를 통해 `MQTT 또는 HTTPS 프로토콜`로 AWS 클라우드에 연결하여 데이터를 보내고 수신한다.  

```kts
implementation("software.amazon.awssdk.iotdevicesdk:aws-iot-device-sdk:1.23.0")
```

### Connecting with MQTT using the AWS IoT Device SDKs

- `MQTT311` 보다는 `MQTT5`를 권장
- [MQTT QoS 옵션](https://docs.aws.amazon.com/iot/latest/developerguide/mqtt.html)은 `QoS Level 2`를 지원하지 않음
- `QoS Level 1`인 경우 [영구 세션](https://docs.aws.amazon.com/iot/latest/developerguide/mqtt.html#mqtt-persistent-sessions)으로 메시지 보존을 지원되며 `CloudWatch Logs` 에 기록 (추가 비용 발생)

### AWS IoT Core policy

AWS IoT 디바이스에 대한 보안 정책으로 권한을 제한하고 일부를 허용할 수 있다. 정책 별 리소스는 [Amazon Resource Names (ARNs)으로 정의](https://docs.aws.amazon.com/iot/latest/developerguide/iot-action-resources.html)한다.

- iot:Connect - AWS IoT Core 메시지 브로커로 `CONNECT` 요청을 보낼 수 있는 권한
- iot:Publish - MQTT 토픽에 대한 `PUBLISH` 권한
- iot:Receive - 메시지 브로커로부터 메시지를 수신할 수 있는 권한
- iot:Subscribe - 토픽 패턴 구독을 위한 `SUBSCRIBE` 권한

#### 정책 변수 예제
- [ClientId 및 SourceIp 정책 변수](https://docs.aws.amazon.com/iot/latest/developerguide/basic-policy-variables.html#basic-policy-variables-example)
- [X.509 인증서 정책 변수](https://docs.aws.amazon.com/iot/latest/developerguide/cert-policy-variables.html)
- 웹 콘솔의 `보안 - 정책` 메뉴에서 `정책 예시`에 따른 정책을 생성할 수 있음
