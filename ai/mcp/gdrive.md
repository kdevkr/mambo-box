## Google Drive MCP Server

```json
{
  "mcpServers": {
    "gdrive": {
      "command": "npx",
      "args": [
        "-y",
        "@modelcontextprotocol/server-gdrive"
      ]
    }
  }
}
```

### Errors

#### ERROR: You must supply a command

```sh
ERROR: You must supply a command.

Execute binaries from npm packages.

  npx [options] <command>[@version] [command-arg]...

  npx [options] [-p|--package <package>]... <command> [command-arg]...

  npx [options] -c '<command-string>'

  npx --shell-auto-fallback [shell]


Options:
  --package, -p          Package to be installed.                       [string]
  --cache                Location of the npm cache.                     [string]
  --always-spawn         Always spawn a child process to execute the command.
                                                                       [boolean]
  --no-install           Skip installation if a package is missing.    [boolean]
  --userconfig           Path to user npmrc.                            [string]
  --call, -c             Execute string as if inside `npm run-script`.  [string]
  --shell, -s            Shell to execute the command with, if any.
                                                       [string] [default: false]
  --shell-auto-fallback  Generate shell code to use npx as the "command not
                         found" fallback.
                                   [string] [choices: "", "bash", "fish", "zsh"]
  --ignore-existing      Ignores existing binaries in $PATH, or in the local
                         project. This forces npx to do a temporary install and
                         use the latest version.                       [boolean]
  --quiet, -q            Suppress output from npx itself. Subcommands will not
                         be affected.                                  [boolean]
  --npm                  npm binary to use for internal operations.
                                                              [string] [default:
  "/Users/username/.nvm/versions/node/v12.22.12/lib/node_modules/npm/bin/npm-cli.js"]
  --node-arg, -n         Extra node argument when calling a node binary.[string]
  --version, -v          Show version number                           [boolean]
  --help, -h             Show help                                     [boolean]

For the full documentation, see the manual page for npx(1).
2025-04-10T02:28:38.371Z [gdrive] [info] Server transport closed
2025-04-10T02:28:38.371Z [gdrive] [info] Client transport closed
2025-04-10T02:28:38.371Z [gdrive] [info] Server transport closed unexpectedly, this is likely due to the process exiting early. If you are developing this MCP server you can add output to stderr (i.e. `console.error('...')` in JavaScript, `print('...', file=sys.stderr)` in python) and it will appear in this log.
2025-04-10T02:28:38.371Z [gdrive] [error] Server disconnected. For troubleshooting guidance, please visit our [debugging documentation](https://modelcontextprotocol.io/docs/tools/debugging) {"context":"connection"}
```

@modelcontextprotocol/server-gdrive 를 글로벌 패키지로 설치 후 전체 경로 지정

```sh
npm install -g @modelcontextprotocol/server-gdrive
```
```json
{
  "mcpServers": {
    "gdrive": {
      "command": "/Users/username/.nvm/versions/node/v22.14.0/bin/node",
      "args": ["/Users/username/.nvm/versions/node/v22.14.0/bin/mcp-server-gdrive"]
    },
  }
}
```

#### Credentials not found.
```sh
Credentials not found. Please run with 'auth' argument first.
2025-04-10T02:32:59.645Z [gdrive] [info] Server transport closed
2025-04-10T02:32:59.646Z [gdrive] [info] Client transport closed
2025-04-10T02:32:59.646Z [gdrive] [info] Server transport closed unexpectedly, this is likely due to the process exiting early. If you are developing this MCP server you can add output to stderr (i.e. `console.error('...')` in JavaScript, `print('...', file=sys.stderr)` in python) and it will appear in this log.
2025-04-10T02:32:59.646Z [gdrive] [error] Server disconnected. For troubleshooting guidance, please visit our [debugging documentation](https://modelcontextprotocol.io/docs/tools/debugging) {"context":"connection"}
```

Google OAuth 크레덴셜 파일을 찾지 못하는 경우 `GDRIVE_CREDENTIALS_PATH` 환경 변수를 지정

```json
{
  "mcpServers": {
    "gdrive": {
      "command": "/Users/username/.nvm/versions/node/v22.14.0/bin/node",
      "args": ["/Users/username/.nvm/versions/node/v22.14.0/bin/mcp-server-gdrive"],
      "env": {
        "GDRIVE_CREDENTIALS_PATH": "/Users/username/servers/.gdrive-server-credentials.json"
      }
    },
  }
}
```
