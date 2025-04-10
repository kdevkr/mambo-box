## Redis MCP Server

- 비밀번호 인증(requirepass)을 사용하는 레디스에 연결할 수 없음 🔥

```json
{
  "mcpServers": {
    "redis": {
      "command": "npx",
      "args": [
        "-y",
        "@modelcontextprotocol/server-redis",
        "redis://localhost:6379"
      ]
    }
  }
}
```

### Errors

#### import: command not found

```sh
/Users/username/.nvm/versions/node/v22.14.0/bin/redis: line 1: import: command not found
/Users/username/.nvm/versions/node/v22.14.0/bin/redis: line 2: import: command not found
/Users/username/.nvm/versions/node/v22.14.0/bin/redis: line 3: import: command not found
/Users/username/.nvm/versions/node/v22.14.0/bin/redis: line 4: import: command not found
/Users/username/.nvm/versions/node/v22.14.0/bin/redis: line 5: import: command not found
/Users/username/.nvm/versions/node/v22.14.0/bin/redis: line 6: //: is a directory
/Users/username/.nvm/versions/node/v22.14.0/bin/redis: line 7: const: command not found
/Users/username/.nvm/versions/node/v22.14.0/bin/redis: line 7: redis://localhost:6379: No such file or directory
/Users/username/.nvm/versions/node/v22.14.0/bin/redis: line 8: const: command not found
/Users/username/.nvm/versions/node/v22.14.0/bin/redis: line 9: const: command not found
/Users/username/.nvm/versions/node/v22.14.0/bin/redis: line 9: //: is a directory
/Users/username/.nvm/versions/node/v22.14.0/bin/redis: line 10: const: command not found
/Users/username/.nvm/versions/node/v22.14.0/bin/redis: line 10: //: is a directory
/Users/username/.nvm/versions/node/v22.14.0/bin/redis: line 11: //: is a directory
/Users/username/.nvm/versions/node/v22.14.0/bin/redis: line 12: syntax error near unexpected token `('
/Users/username/.nvm/versions/node/v22.14.0/bin/redis: line 12: `const redisClient = createClient({'
2025-04-10T01:59:50.636Z [redis2] [info] Server transport closed
2025-04-10T01:59:50.637Z [redis2] [info] Client transport closed
2025-04-10T01:59:50.637Z [redis2] [info] Server transport closed unexpectedly, this is likely due to the process exiting early. If you are developing this MCP server you can add output to stderr (i.e. `console.error('...')` in JavaScript, `print('...', file=sys.stderr)` in python) and it will appear in this log.
2025-04-10T01:59:50.637Z [redis2] [error] Server disconnected. For troubleshooting guidance, please visit our [debugging documentation](https://modelcontextprotocol.io/docs/tools/debugging) {"context":"connection"}
```

[npx-for-claude](https://github.com/modelcontextprotocol/servers/issues/64#issuecomment-2730913259)를 사용해도 내부 코드에서 오류가 발생하므로 전체 경로를 지정해서 실행해야함

```json
{
  "mcpServers": {
    "redis": {
      "command": "/Users/username/.nvm/versions/node/v22.14.0/bin/node",
      "args": [
        "/Users/username/.nvm/versions/node/v22.14.0/bin/redis",
        "redis://localhost:6379"
      ]
    }
  }
}
```
