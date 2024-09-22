## REST API with Amazon SQS

![Integrate Amazon API Gateway with Amazon SQS to handle asynchronous REST APIs](https://docs.aws.amazon.com/images/prescriptive-guidance/latest/patterns/images/pattern-img/70984dee-e49f-4446-9d52-49ce826c3909/images/737ba0b2-da8f-4478-8c54-0a4835fd69f9.png)

```sh
# Content-Type: application/x-www-form-urlencoded
Action=SendMessage&MessageBody=$util.urlEncode($input.body)
```

- 실행 역할의 IAM Role은 [SQS-SendMessage](https://docs.aws.amazon.com/apigateway/latest/developerguide/http-api-develop-integrations-aws-services-reference.html#SQS-SendMessage) 권한을 요구
- [Amazon SQS 의 쿼리 프로토콜을 사용하여 POST 요청](https://docs.aws.amazon.com/ko_kr/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-making-api-requests-xml.html#structure-post-request) 형태로 [매핑 템플릿에서 Velocity Template Language (VTL)을 사용](https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-mapping-template-reference.html#input-variable-reference)하여 요청 페이로드를 쿼리 스트링 형태로 변환
- [API Gateway 리소스 정책을 사용하여 REST API에 대한 액세스 제어](https://docs.aws.amazon.com/ko_kr/apigateway/latest/developerguide/apigateway-resource-policies.html)

### Amazon SQS Access Policy
```json
{
  "Version": "2012-10-17",
  "Id": "__default_policy_ID",
  "Statement": [
    {
      "Sid": "__owner_statement",
      "Effect": "Allow",
      "Principal": {
        "AWS": "xxxx"
      },
      "Action": [
        "SQS:*"
      ],
      "Resource": "arn:aws:sqs:ap-northeast-2:xxxx:sample"
    },
    {
      "Sid": "__sender_statement",
      "Effect": "Allow",
      "Principal": {
        "AWS": [
          "arn:aws:iam::xxxx:role/apig-sqs-send-msg-policy"
        ]
      },
      "Action": [
        "SQS:SendMessage"
      ],
      "Resource": "arn:aws:sqs:ap-northeast-2:xxxx:sample"
    }
  ]
}
```

### Amazon API Gateway Resource Policy
```json
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Deny",
            "Principal": "*",
            "Action": "execute-api:Invoke",
            "Resource": "execute-api:/*",
            "Condition" : {
                "NotIpAddress": {
                    "aws:SourceIp": [ "175.194.103.111/32" ]
                }
            }
        },
        {
            "Effect": "Allow",
            "Principal": "*",
            "Action": "execute-api:Invoke",
            "Resource": "execute-api:/*"
        }
    ]
}
```

## Links
- [Integrate Amazon API Gateway with Amazon SQS to handle asynchronous REST APIs](https://docs.aws.amazon.com/prescriptive-guidance/latest/patterns/integrate-amazon-api-gateway-with-amazon-sqs-to-handle-asynchronous-rest-apis.html)
- [How do I integrate an API Gateway REST API with Amazon SQS and resolve common errors?](https://repost.aws/knowledge-center/api-gateway-rest-api-sqs-errors)
