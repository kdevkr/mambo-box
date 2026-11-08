# PHP2Shell (PHP 코어 원격 코드 실행 취약점)

## 개요
- PHP 코어 엔진의 메모리 관리 결함으로 발생한 비인증 원격 코드 실행(RCE) 취약점
- 식별자: [CVE-2026-109618](https://github.com/php/php-src/security/advisories/GHSA-w8hw-w9fx-j79w), [CVE-2026-109619](https://github.com/php/php-src/security/advisories/GHSA-6wmf-4rv5-p3rp) (CVSS 9.2)
- 영향 버전: PHP 5.4 이후 출시된 모든 버전 (지원 종료된 5.x~8.1은 공식 패치 미제공)
- [Wiz Research 분석](https://news.hada.io/topic?id=35761) 기준 코드 결함과 무관하게 WordPress, Drupal 등 PHP 웹 환경 전반에 영향

## 원인과 패치 지연 배경
- 메모리 부족(OOM) 발생 시 힙은 해제되지만 내부 전역 상태와 공유 메모리가 남는 결함
- 다음 요청이나 다른 워커가 남은 포인터를 재사용하며 메모리 손상(UAF) 및 유출 발생
- 2024년 [외부 보안 감사](https://thephp.foundation/blog/2025/04/10/php-core-security-audit-results/) 당시 코어 개발자가 OOM 처리 문제를 이론적으로 이미 인지
- [PHP 재단 발표](https://news.hada.io/topic?id=35766)에 따르면 하위 호환성 문제, 확장 모듈 수정 부담, 합의 지연, 인력 부족으로 패치 보류
- 2026년 8월 외부 연구로 실제 원격 코드 실행이 입증되며 최우선 과제로 전환

## AI 활용과 공개 과정의 혼선
- OpenAI의 [Patch the Planet](https://openai.com/index/patch-the-planet/)을 통해 보안 연구진이 GPT-5.6 Sol, Gemini 4 Argon 등으로 공격 체인 및 PoC 개발 자동화
- 수개월 걸리던 메모리 조작 공격 코드가 AI 지원으로 수시간~일주일 만에 완성
- [AWS MadPot 허니팟](https://news.hada.io/topic?id=35825)에서 공식 공개 4일 전인 10월 17일부터 공격 시도 포착
- 보안 업체의 시연 영상 조기 노출과 배포 업체의 엠바고 파기로 방어 골든타임 상실 및 일부 국가 웹사이트 일시 중단

## 타임라인
- 2024년: 외부 보안 감사 중 코어 개발자가 OOM 메모리 손상 가능성 인지 (수정 보류)
- 2026년 6월 22일: OpenAI 'Patch the Planet' 프로그램 공개
- 2026년 7월 30일: 보안 업체 Calif, PHP 코어 감사 시작
- 2026년 8월 11일: Calif와 OpenAI가 OOM 기반 RCE 경로 각각 제보
- 2026년 8월 19일~24일: Wiz가 AI 모델로 취약점 발굴 및 WordPress·Drupal RCE 실증 후 제보
- 2026년 9월 21일: PHP 팀과 인프라 파트너가 공동 패치 작업 시작
- 2026년 10월 17일: AWS 허니팟에서 공개 전 최초 공격 시도 포착
- 2026년 10월 20일 15:00 UTC: SNS와 포럼에 CVE 번호 유출
- 2026년 10월 20일 19:30 UTC: PHP 팀, 보안 패치 일정을 하루 앞당겨 공지
- 2026년 10월 20일 20:00 UTC: Calif가 X에 공격 시연 영상을 실수로 게시하며 PoC 제작 확산
- 2026년 10월 21일 07:41 UTC: Chainguard가 엠바고 해제 6시간 전 패치 이미지 조기 배포
- 2026년 10월 21일 14:00 UTC: PHP 공식 패치 배포 (8.5.12, 8.4.27, 8.3.36, 8.2.35)
- 2026년 10월 22일: 전 세계 공격 시도 급증 및 긴급 패치 진행

## 대응 및 완화 조치
- [로그프레소 보안 권고](https://logpresso.com/ko/blog/2026-10-21-php2shell-security-advisory) 기준 완전한 해결책은 패치된 PHP 버전(8.2 이상) 업그레이드 또는 리눅스 배포판 백포트 패치 적용
- 패치 전 임시 완화 설정:
  - `session.upload_progress.enabled = 0` 설정 적용 후 재시작 (파일 업로드는 유지되고 진행률 표시만 중단)
  - Nginx, Apache, WAF에서 불필요한 멀티파트(`multipart/form-data`) 요청 및 `PHP_SESSION_UPLOAD_PROGRESS` 문자열 차단
  - 멀티파트 경계값(boundary)을 안전하게 재인코딩하는 프록시 배치
- 침해 점검 항목:
  - 워커 비정상 종료(`SIGSEGV`, `SIGABRT`) 및 500/502 에러 급증 로그 확인
  - `php-fpm` 및 웹 서버 하위의 비정상 자식 프로세스(`sh`, `bash`, `curl`, `nc` 등) 확인
  - 비정상 크기의 `PHPSESSID` 쿠키 및 최근 생성·변경된 PHP 웹쉘 파일 탐색
