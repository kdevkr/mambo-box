## jmap

```shell
# jmap -dump:format=b, file=<file-path> <pid>
jmap -dump:format=b, file=./dump.hprof 12345
```

- -XX:+HeapDumpOnOutOfMemoryError
- -XX:HeapDumpPath=<dump_dir>

### Links
- [Different Ways to Capture Java Heap Dumps](https://www.baeldung.com/java-heap-dump-capture)
- [Creating and Analyzing Java Heap Dumps](https://reflectoring.io/create-analyze-heapdump/)
- [Memory Analyzer (MAT)](https://www.eclipse.org/mat/)