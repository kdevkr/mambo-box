## GlitchTip

[GlitchTip](https://glitchtip.com)은 Sentry 호환 오픈소스(AGPLv3) 에러 트래킹 및 성능 모니터링 플랫폼

- Sentry SDK 호환 (DSN만 교체)
- 경량 아키텍처 (1GB RAM 내외 저사양 서버 구동)
- 에러 트래킹, 성능 모니터링, 업타임 모니터링 지원
- AI 에이전트 연동 지원 (MCP 및 CLI)
- i18n 미지원 (영문 전용)

### Docker Compose 배포

공식 [설치 문서](https://glitchtip.com/documentation/install)의 [compose.yml](https://glitchtip.com/assets/compose.sample.yml) 다운로드 후 실행

```sh
# compose.yml 다운로드
curl -o compose.yml https://glitchtip.com/assets/compose.sample.yml

# 실행
docker compose up -d
```

#### 환경변수

- `ALLOWED_HOSTS`: 허용 도메인 지정 (`"app.example.com,localhost"`)
- `GLITCHTIP_ENABLE_UPTIME`: Uptime 기능 비활성화 (`"False"`)
- `GLITCHTIP_ENABLE_MCP`: 내장 MCP 서버 활성화 (`"True"`)

### GlitchTip CLI

릴리즈 관리 및 소스맵 업로드를 위한 공식 [CLI](https://glitchtip.com/documentation/cli)

#### 설치

```sh
# Linux / macOS
curl -fsSL https://glitchtip.com/install.sh | sh

# Windows (Cargo)
cargo install glitchtip-cli
```

#### 인증 및 설정

```sh
# CLI 로그인 (Profile > Auth Tokens 입력)
glitchtip-cli --url https://your-glitchtip.example.com login

# 설정 파일 (~/.config/glitchtip-cli/config)
[auth]
token=<auth-token>

[defaults]
url=https://your-glitchtip.example.com
org=<org-slug>

# 프로젝트별 설정 (.sentryclirc)
[defaults]
project=<project-slug>
```

### MCP (Model Context Protocol)

AI 에이전트 연동을 위한 [내장 MCP](https://glitchtip.com/documentation/mcp) 서버 지원

- 엔드포인트: `https://your-glitchtip.example.com/mcp`
- 인증 방식: OAuth 2.0 또는 Auth 토큰 (Profile > Auth Tokens)

#### 클라이언트 연동

```json
{
  "mcpServers": {
    "glitchtip": {
      "url": "https://your-glitchtip.example.com/mcp"
    }
  }
}
```
