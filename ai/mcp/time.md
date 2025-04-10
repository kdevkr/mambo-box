## Time MCP Server

```json
"mcpServers": {
  "time": {
    "command": "uvx",
    "args": ["mcp-server-time"]
  }
}
```

### Errors

#### zoneinfo._common.ZoneInfoNotFoundError: 'No time zone found with key KST'
```sh
Traceback (most recent call last):
  File "/Users/username/Library/Application Support/uv/python/cpython-3.12.9-macos-aarch64-none/lib/python3.12/zoneinfo/_common.py", line 12, in load_tzdata
    return resources.files(package_name).joinpath(resource_name).open("rb")
           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  File "/Users/username/Library/Application Support/uv/python/cpython-3.12.9-macos-aarch64-none/lib/python3.12/pathlib.py", line 1013, in open
    return io.open(self, mode, buffering, encoding, errors, newline)
           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
FileNotFoundError: [Errno 2] No such file or directory: '/Users/username/.cache/uv/archive-v0/S2oZOdPKchj5YFK67-25o/lib/python3.12/site-packages/tzdata/zoneinfo/KST'

During handling of the above exception, another exception occurred:

Traceback (most recent call last):
  File "/Users/username/.cache/uv/archive-v0/S2oZOdPKchj5YFK67-25o/bin/mcp-server-time", line 12, in <module>
    sys.exit(main())
             ^^^^^^
  File "/Users/username/.cache/uv/archive-v0/S2oZOdPKchj5YFK67-25o/lib/python3.12/site-packages/mcp_server_time/__init__.py", line 15, in main
    asyncio.run(serve(args.local_timezone))
  File "/Users/username/Library/Application Support/uv/python/cpython-3.12.9-macos-aarch64-none/lib/python3.12/asyncio/runners.py", line 195, in run
    return runner.run(main)
           ^^^^^^^^^^^^^^^^
  File "/Users/username/Library/Application Support/uv/python/cpython-3.12.9-macos-aarch64-none/lib/python3.12/asyncio/runners.py", line 118, in run
    return self._loop.run_until_complete(task)
           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  File "/Users/username/Library/Application Support/uv/python/cpython-3.12.9-macos-aarch64-none/lib/python3.12/asyncio/base_events.py", line 691, in run_until_complete
    return future.result()
           ^^^^^^^^^^^^^^^
  File "/Users/username/.cache/uv/archive-v0/S2oZOdPKchj5YFK67-25o/lib/python3.12/site-packages/mcp_server_time/server.py", line 119, in serve
    local_tz = str(get_local_tz(local_timezone))
                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  File "/Users/username/.cache/uv/archive-v0/S2oZOdPKchj5YFK67-25o/lib/python3.12/site-packages/mcp_server_time/server.py", line 45, in get_local_tz
    return ZoneInfo(str(tzinfo))
           ^^^^^^^^^^^^^^^^^^^^^
  File "/Users/username/Library/Application Support/uv/python/cpython-3.12.9-macos-aarch64-none/lib/python3.12/zoneinfo/_common.py", line 24, in load_tzdata
    raise ZoneInfoNotFoundError(f"No time zone found with key {key}")
zoneinfo._common.ZoneInfoNotFoundError: 'No time zone found with key KST'
2025-04-10T02:15:25.495Z [time] [info] Server transport closed
2025-04-10T02:15:25.495Z [time] [info] Client transport closed
2025-04-10T02:15:25.495Z [time] [info] Server transport closed unexpectedly, this is likely due to the process exiting early. If you are developing this MCP server you can add output to stderr (i.e. `console.error('...')` in JavaScript, `print('...', file=sys.stderr)` in python) and it will appear in this log.
2025-04-10T02:15:25.495Z [time] [error] Server disconnected. For troubleshooting guidance, please visit our [debugging documentation](https://modelcontextprotocol.io/docs/tools/debugging) {"context":"connection"}
```

자동으로 반영되는 [시스템 타임존 표기법으로 인한 문제](https://github.com/modelcontextprotocol/servers/issues/786)가 있으므로 `--local-timezone`을 명시해야함

```json
"mcpServers": {
  "time": {
    "command": "uvx",
    "args": ["mcp-server-time", "--local-timezone=Asia/Seoul"]
  }
}
```
