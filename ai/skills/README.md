# Agent Skills

AI 코딩 에이전트에게 지침과 워크플로우를 자동화하기 위한 능력을 기술

- 사용자의 확인 절차없이 관련 작업 시 자동으로 워크플로우를 수행
- 에이전트가 언제 이 스킬을 사용할 수 있고 불가능한지를 부여

## Directory structure

```sh
skill-name/
├── SKILL.md          # Required: metadata + instructions
├── scripts/          # Optional: executable code
├── references/       # Optional: documentation
├── assets/           # Optional: templates, resources
└── ...               # Any additional files or directories
```

## How to use

에이전트가 스스로 사용하거나 사용자가 직접 `/skill-name` 으로 호출

- Antigravity → `~/.gemini/antigravity/skills/{skillFolder}/SKILL.md` or `{projectFolder}/.agents/skills/{skillFolder}/SKILL.md`
- Claude Code → `.claude/skills/{skillFolder}/SKILL.md`

## Reference

- [Open agent skills standard](https://agentskills.io/home)
- [Claude를 skills로 확장하기](https://code.claude.com/docs/ko/skills)
- [Google Antigravity - Agent Skills](https://antigravity.google/docs/skills)
- [heilcheng/awesome-agent-skill](https://github.com/heilcheng/awesome-agent-skill)
- [skills.sh](https://skills.sh/)
