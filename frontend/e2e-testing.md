# E2E 테스팅

사용자 관점에서 서비스 전체 흐름을 검증하는 통합 테스팅 환경

## 통합 E2E 테스팅 스택

- [tester-army/e2e](https://github.com/tester-army/e2e)
  - 자연어 명령 기반으로 Web·Mobile 사용자 여정을 자동 탐색하는 오픈소스 AI E2E 테스팅 프레임워크
  - 첫 실행 경로를 캐싱해 UI 변경 전까지 LLM 호출 없이 재실행
  - [Tester Army e2e Skill](https://www.skills.sh/tester-army/e2e/e2e)
- [axe-core](https://github.com/dequelabs/axe-core)
  - E2E 주행 중 모달·드롭다운 등 동적 DOM의 웹 접근성(WCAG) 결함을 실시간 동시 검증
  - [Addy Osmani Accessibility Skill](https://www.skills.sh/addyosmani/web-quality-skills/accessibility)
- [Vitest](https://github.com/vitest-dev/vitest)
  - E2E로 검증하기 어려운 복잡한 비즈니스 엣지 케이스와 내부 로직을 모킹 기반으로 사전 점검
  - [Anthony Fu Vitest Skill](https://www.skills.sh/antfu/skills/vitest)
- [Grafana k6](https://github.com/grafana/k6)
  - E2E 사용자 시나리오를 기반으로 동시 트래픽을 가해 시스템 임계치와 응답 속도 측정
  - [Grafana k6 Skill](https://www.skills.sh/grafana/skills/k6)

## 통합 워크플로우 예시

E2E 사용자 시나리오 검증 시 axe-core를 포함하여 기능과 웹 접근성을 함께 점검

```ts
// tests/checkout.e2e.ts
import { test, expect } from 'e2e'
import AxeBuilder from '@axe-core/playwright'

test('체크아웃 여정 주행 및 동적 접근성 동시 점검', async ({ page, app, agent, screen }) => {
  // 1. 페이지 진입 및 정적 접근성 점검
  await app.open('/checkout')
  const initialA11y = await new AxeBuilder({ page }).analyze()
  expect(initialA11y.violations).toEqual([])

  // 2. AI 에이전트 인터랙션 (동적 DOM 상태 변화)
  await agent.act('결제 수단 선택 후 약관 동의 모달 열기')

  // 3. 모달 활성화 상태의 접근성 결함 즉시 점검
  const modalA11y = await new AxeBuilder({ page }).analyze()
  expect(modalA11y.violations).toEqual([])

  // 4. 최종 비즈니스 상태 완료 검증
  await agent.act('모달 닫고 결제 완료 버튼 클릭')
  await expect(screen.getByRole('status')).toContainText('완료')
})
```
