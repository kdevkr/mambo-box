# 보안 검사 도구

허가된 자산의 보안 점검에 사용하는 도구 모음

## 자산 탐색

| 도구 | 용도 |
| --- | --- |
| [subfinder](https://github.com/projectdiscovery/subfinder) | 공개 소스를 활용한 수동적 서브도메인 수집 |
| [dnsx](https://github.com/projectdiscovery/dnsx) | DNS 레코드 조회 및 호스트의 DNS 해석 확인 |

## 포트·서비스 확인

| 도구 | 용도 |
| --- | --- |
| [naabu](https://github.com/projectdiscovery/naabu) | 호스트·IP의 열린 포트 탐색 |
| [Nmap](https://github.com/nmap/nmap) | 열린 포트별 서비스 종류·버전 식별 |
| [httpx](https://github.com/projectdiscovery/httpx) | HTTP 서비스 응답·상태 코드·제목·웹 기술 확인 |

## 웹 경로·입력 지점 탐색

| 도구 | 용도 |
| --- | --- |
| [katana](https://github.com/projectdiscovery/katana) | 웹 페이지·JavaScript 크롤링을 통한 URL·엔드포인트 수집 |
| [ffuf](https://github.com/ffuf/ffuf) | 워드리스트 기반 경로·파라미터 등 웹 퍼징 |

## 취약점 검사·검증

| 도구 | 용도 |
| --- | --- |
| [Nuclei](https://github.com/projectdiscovery/nuclei) | YAML 템플릿 기반 취약점·설정 오류 검사 |
| [SSRFmap](https://github.com/swisskyrepo/SSRFmap) | HTTP 요청 파일과 파라미터를 이용한 SSRF 점검 |
| [Interactsh](https://github.com/projectdiscovery/interactsh) | DNS·HTTP 등 외부 콜백을 통한 OOB 상호작용 확인 |

## 저장소·파일 비밀정보 검사

| 도구 | 용도 |
| --- | --- |
| [TruffleHog](https://github.com/trufflesecurity/trufflehog) | Git 저장소·파일의 API 키·토큰 등 비밀정보 노출 탐지 |

## 의존성·컨테이너 검사

| 도구 | 용도 |
| --- | --- |
| [Trivy](https://github.com/aquasecurity/trivy) | 의존성·컨테이너 이미지의 알려진 취약점 및 IaC 구성 오류 검사 |

## 연계 흐름

```text
자산 탐색 → 포트·서비스 확인 → 웹 경로·입력 지점 탐색 → 취약점 검사·검증
subfinder   naabu → Nmap      katana                 nuclei
dnsx        httpx             ffuf                   SSRFmap
                                                     Interactsh
```

- 목적에 따라 필요한 단계를 선택하며, 비밀정보·의존성·컨테이너 검사는 별도로 수행
- 단계별 결과에서 점검 범위를 확인한 후 다음 도구에 전달
- 탐지 결과는 재현 및 원인 확인을 통해 최종 판단
