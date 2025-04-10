## Filesystem MCP Server

```json
{
  "mcpServers": {
    "filesystem": {
      "command": "npx",
      "args": [
        "-y",
        "@modelcontextprotocol/server-filesystem",
        "/Users/username/Desktop"
      ]
    }
  }
}
```

### Errors

#### command not found: /Users/Mambo/Desktop

- [노드 버전 관리 사용 시 MCP 서버 실행 오류](https://github.com/modelcontextprotocol/servers/issues/64): nvm, fnm, asdf, mise...
- [별도의 쉘 스크립트를 만들어서 사용](https://github.com/modelcontextprotocol/servers/issues/64#issuecomment-2730913259)

```sh
$ sudo vi /usr/local/bin/npx-for-claude

---
#!/usr/bin/env bash
export PATH="/Users/username/.nvm/versions/node/v22.14.0/bin:$PATH"
exec npx "$@"
---

$ sudo chmod +x /usr/local/bin/npx-for-claude
```

```json
{
  "mcpServers": {
    "filesystem": {
      "command": "npx-for-claude",
      "args": [
        "-y",
        "@modelcontextprotocol/server-filesystem",
        "/Users/username/Desktop"
      ]
    }
  }
}
```

#### Error: spawn npx ENOENT

ref: [MCP Services Not Working? A Silver Bullet Approach](https://medium.com/@kaue.tech/mcp-services-not-working-a-silver-bullet-approach-claude-mcp-agent-tutorial-4117c28613b1)

```json
{
  "mcpServers": {
    "filesystem": {
      "command": "/Users/username/.nvm/versions/node/v22.14.0/bin/npx",
      "args": [
        "-y",
        "@modelcontextprotocol/server-filesystem",
        "/Users/username/Desktop"
      ]
    }
  }
}
```
