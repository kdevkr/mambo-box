# Codex

## 설치 및 설정

```bash
# 플러그인 등록 및 설치
/plugin marketplace add openai/codex-plugin-cc
/plugin install codex@openai-codex
/reload-plugins

# 연동 상태 확인
/codex:setup
```

- Codex CLI 전역 설치 필요 시: `npm install -g @openai/codex`
- 인증 필요 시: `!codex login`

## 설정 파일

- `~/.codex/config.toml`: 사용자 정의 설정 관리

## 규칙 및 지침 파일

- `~/.codex/AGENTS.md`: 사용자 전역 지침 파일 참조
- `AGENTS.overrides.md`: 프로젝트 단위 오버라이드 지침 파일 참조

## 스킬

- 공식 문서: [Build Skills](https://learn.chatgpt.com/docs/build-skills)
- 저장 경로: `~/.codex/skills` 또는 `~/.agents/skills`
- 호출 방식: `$` 기호로 호출 (예: `$스킬명`)

## Claude Code 플러그인

Claude Code에서 OpenAI Codex를 사용하는 플러그인 ([openai/codex-plugin-cc](https://github.com/openai/codex-plugin-cc))

## 관련 링크

- [거의 모든 것을 위한 Codex](https://news.hada.io/topic?id=28614)
- [소프트웨어 엔지니어를 위한 Codex](https://news.hada.io/topic?id=27629)
- [Codex, 활용 사례 모음](https://news.hada.io/topic?id=29847)
- [Codex Security](https://news.hada.io/topic?id=31921)
