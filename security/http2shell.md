# HTTP2Shell (Brotli 디코더 RCE 취약점)

## 개요
- Brotli C 디코더 결함으로 인한 양방향 원격 코드 실행(RCE) 취약점
- 식별자: [CVE-2026-111497](https://www.cve.org/CVERecord?id=CVE-2026-111497) (CVSS 9.2)
- 별칭(AKA): Node2Shell, Python2Shell, Brotli2Shell, Broccoli2Shell
- HTTP Brotli 압축 해제(`Content-Encoding: br`) 환경 전반에 영향

## 원인 및 메커니즘
- `DecodeBlockTypeAndLength()`의 블록 전환 검증 오류로 8바이트 버퍼 범위 외 쓰기(OOB Write) 발생
- 업스트림 패치([commit 0ed4268](https://github.com/google/brotli/commit/0ed4268a4401abcb4472096340477cf4af7d1a2b))에서 오류 코드(-17) 반환하도록 수정
- 악성 압축 요청(서버 장악) 및 악성 압축 응답(클라이언트 장악) 양방향 공격 가능

## 영향 범위 및 대상 제품
- JavaScript / TypeScript: Node.js, Bun, Express, body-parser
- Python: requests, urllib3, httpx, aiohttp, Scrapy (`Brotli`, `brotlicffi` 연동)
- C / C++: curl, FFmpeg, Envoy, Istio (`libbrotli` 의존 바이너리)
- C# / .NET: .NET 8~11 RC (`System.IO.Compression`)
- Java: Netty 생태계 (`brotli4j`)
- OS / 인프라: Linux 배포판(Debian, Ubuntu, Alpine 등 `libbrotli`) 및 컨테이너 베이스 이미지

## 대응 및 완화
- 최신 보안 버전 업그레이드 (Brotli 1.2.1, Node.js 22.23.4+, Bun 1.4.4, Python brotli 1.2.1 등)
- 미패치 시 WAF·프록시의 `Content-Encoding: br` 차단 및 클라이언트 Brotli 디코딩 비활성화
- 업데이트 후 메모리 상주 프로세스(데몬, 컨테이너) 반드시 재시작

## 관련 자료
- [Broccoli2Shell Recall](https://broccoli2shell.com/#recall)
- [Brandefense - HTTP2Shell 분석](https://brandefense.io/blog/http2shell-brotli-cve-2026-111497/)
- [Aikido Security - Python 생태계 영향 분석](https://www.aikido.dev/blog/python-packages-vulnerable-node2shell-brotli-cve-2026-111497)
