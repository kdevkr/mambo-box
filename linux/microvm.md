# MicroVM

## Firecracker

- [Firecracker](https://firecracker-microvm.github.io/)
- AWS가 **AWS Lambda** 및 **AWS Fargate** 서버리스를 위해 개발한 오픈소스 초경량 가상 머신(MicroVM)
- 컨테이너의 **속도(~5ms)**와 VM의 **하드웨어 격리(KVM)**를 결합
- 특정 작업 완료 시 즉시 소멸(Ephemeral)되는 온디맨드 샌드박스 환경 제공
- AI가 실행하는 코드를 호스트 시스템 피해 없이 안전하게 구동 가능한 격리 환경 제공

## AWS Lambda MicroVM (2026.06)

- **출시 내용**: 개발자가 수명 주기(생성/유지/종료)를 직접 제어하는 **독립 MicroVM 샌드박스** 지원
- **주요 용도**: AI 에이전트 코드 실행 격리, 브라우저 자동화 세션, 상태 유지형 샌드박스
- [AWS Lambda MicroVM 출시 (2026.06.25)](https://aws.amazon.com/ko/blogs/korea/run-isolated-sandboxes-with-full-lifecycle-control-aws-lambda-introduces-microvms/)
