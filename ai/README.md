# Artificial Intelligence

인공지능 및 AI 에이전트 엔지니어링 관련 문서 모음

## 에이전트 아키텍처 및 환경

- [Agentic Development Environment (ADE)](./ade.md): 자율 에이전트 작업 및 멀티 에이전트 오케스트레이션을 지원하는 차세대 개발 환경
- [Agentic IDE](./agentic-ide.md): 터미널 및 IDE 기반 코딩 에이전트 도구 모음
- [AI Agents](./ai-agent.md): 챗봇, 코드 에디터, 이미지 생성기 등 분야별 AI 서비스 목록
- [Harness Engineering](./harness-engineering.md): 가드레일과 워크플로우를 통한 에이전트 실행 환경 통제 및 신뢰성 확보 엔지니어링
- [Loop Engineering](./loop-engineering.md): 추론과 도구 사용, 인간 개입(HITL), 자가 교정 등 에이전트 자율 루프 설계 기법

## API 및 모델 연동

- [Streaming API](./streaming-api.md): Server-Sent Events(SSE) 기반 LLM 응답 실시간 스트리밍 연동 방식
- [Anomaly Detection](./anomaly-detection.md): 통계적 기법 및 머신러닝 모델 기반 시계열 이상치 탐지 알고리즘

## 에이전트 스킬

- [Agent Skills](./skills/README.md): 에이전트 워크플로우 자동화 및 맞춤형 능력 확장을 위한 스킬 패키징 가이드
- [Frontend Design Skills](./skills/frontend-design.md): 고품질 웹 UI/UX 디자인 및 코드 리뷰를 위한 프론트엔드 특화 스킬 모음
- [Code Review Skills](./skills/review.md): 품질, 보안 취약점, 복잡도 검증을 위한 에이전트 코드 리뷰 스킬 모음

## Model Context Protocol (MCP)

- [Filesystem MCP](./mcp/filesystem.md): 로컬 파일 읽기 및 쓰기를 지원하는 파일시스템 연동 서버
- [Google Drive MCP](./mcp/gdrive.md): 구글 드라이브 파일 검색 및 조회를 위한 연동 서버
- [GitHub MCP](./mcp/github.md): GitHub 저장소 및 이슈 관리를 위한 연동 서버
- [Playwright MCP](./mcp/playwright-mcp.md): 브라우저 제어 및 웹 UI 테스트 자동화를 위한 연동 서버
- [Redis MCP](./mcp/redis.md): Redis 인스턴스 탐색 및 데이터 관리를 위한 연동 서버
- [Time MCP](./mcp/time.md): 표준 시간 및 로컬 타임존 조회를 지원하는 시간 연동 서버
