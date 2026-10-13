# e2b-embed

- [E2B Embed 소개](https://e2b.dev/resources/introducing-e2b-embed) — 2026.09.30 공개
- [e2b-dev/runtime](https://github.com/e2b-dev/runtime)
- MicroVM 샌드박스 환경을 위한 셀프 호스팅 스택
- 단일 머신에서 실행하는 제품(Single-machine product)
- 메모리 12GB 이상 권장
- 중첩 가상화(Nested Virtualization)를 지원하는 머신 필요
- AWS 환경: Intel 기반 M8i EC2 서버 필요
- 통신 제약: Plain HTTP 사용

## 인증 및 SDK 호출

- 머신 하나에 배포한 Embed 스택 하나당 Team API Key 생성
- Team API Key 노출 방지를 위해 백엔드에서 SDK 호출 ([공식 문서](https://github.com/e2b-dev/runtime/blob/main/embed/docs/REFERENCE.md#secrets))

## Docker Compose 실행 예시

```bash
mkdir e2b && cd e2b
curl -fsSL --remote-name-all "https://raw.githubusercontent.com/e2b-dev/runtime/main/embed/compose/{compose.yaml,.env}"
docker compose up -d --wait
```
