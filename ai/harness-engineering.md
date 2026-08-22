# Harness Engineering

단순히 프롬프트 작성만으로는 개선하기 어려운 에이전트 품질 문제를 보완하기 위해, 실시간 가드레일(Guardrails)과 자체 실행 및 평가를 수행하는 워크플로우 환경을 구축

---

## 가드레일/하네스 구축을 위한 프로젝트 구성 요소 및 구축 방안

- **`CLAUDE.md` (전역 규칙)**: 프로젝트 루트에 생성하며 상시 로드(Always-on)할 코딩 표준, 컴파일/테스트 명령어, 디렉토리 권한 제한 명문화
- **`.agents/rules/` (세부 규칙)**: 특정 기술 스택이나 도메인 규약(예: Spring Security 규칙 등)에 특화된 가이드라인을 개별 마크다운 파일로 구성하여 배치
- **`.agents/workflows/` (워크플로우)**: 기능 구현(`/implement`), 문제 해결(`/troubleshoot`) 등 자율적인 해결 단계와 TDD 검증 파이프라인 정의
- **`.agents/skills/` (모듈 스킬)**: 개별 폴더 내 `SKILL.md`를 통해 온디맨드(On-demand) 실행 능력을 패키징하고 내부 도구 호출 범위를 제어

## 유래 및 기원

- **기원**: 마틴 파울러(Martin Fowler) 등 전통 소프트웨어 공학의 '테스트 하네스' 개념을 AI/LLM 도메인으로 확장 적용
- **AI 에이전트 분야 소개**: 구글의 개발자 관계(Developer Relations) 디렉터인 **애디 오스마니(Addy Osmani)**가 "Agent Harness Engineering" 아티클을 통해 모델 단독 개발이 아닌 모델을 안전하게 둘러싸는 '하네스(장비)' 구축의 필요성을 대중적으로 정립

### OpenAI의 하네스 엔지니어링 사례 및 연구

- **Zero-Code 개발 실험**: OpenAI 내부 팀에서 사람이 코드를 한 줄도 작성하지 않고 Codex 모델만을 이용해 사내 소프트웨어 제품(베타 버전)을 성공적으로 빌드 및 배포
- **비계(Scaffolding) 투자**: 개발자의 역할이 코드 작성에서 에이전트가 안전하게 활동할 수 있도록 돕는 테스트 파이프라인, 샌드박스 등의 '하네스(Scaffolding)'를 구축하는 것으로 변화
- **Symphony로의 진화**: 여러 자율 에이전트가 병렬로 작동할 때 발생하는 인간의 주의력(Attention) 병목 현상을 해결하기 위해, 태스크와 에이전트 세션을 오케스트레이션하는 **Symphony** 시스템으로 확장

## 하네스 구축을 위한 관련 오픈소스

- [affaan-m/ECC (Everything Claude Code)](https://github.com/affaan-m/ECC)
- [wshobson/agents](https://github.com/wshobson/agents)

## References

- [Harness Engineering - Martin Fowler](https://martinfowler.com/articles/harness-engineering.html)
- [Agent Harness Engineering - Addy Osmani](https://addyosmani.com/blog/agent-harness-engineering/)
- [Harness Engineering - OpenAI](https://openai.com/ko-KR/index/harness-engineering/)
