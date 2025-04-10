## Github MCP Server

```json
{
  "mcpServers": {
    "github": {
      "command": "docker",
      "args": [
        "run",
        "-i",
        "--rm",
        "-e",
        "GITHUB_PERSONAL_ACCESS_TOKEN",
        "ghcr.io/github/github-mcp-server"
      ],
      "env": {
        "GITHUB_PERSONAL_ACCESS_TOKEN": "<YOUR_TOKEN>"
      }
    }
  }
}
```

### Errors

#### 조직 리파지토리를 조회할 수 없는 경우

ref: [github-mcp-server#153](https://github.com/github/github-mcp-server/issues/153)

- [Prerequisites](https://github.com/github/github-mcp-server?tab=readme-ov-file#prerequisites) 에서는 Fine-grained PAT 발급되도록 링크가 유도되어있음.
- [Fine-grained PAT](https://github.blog/changelog/2025-03-18-fine-grained-pats-are-now-generally-available/)는 사용할 수 없으므로 `read:org` 스코프가 포함된 `Classic PAT`를 발급하여 사용
