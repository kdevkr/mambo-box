#### Install scoop
```ps
PS C:\Users\Mambo> Set-ExecutionPolicy RemoteSigned -Scope CurrentUser
PS C:\Users\Mambo> irm get.scoop.sh | iex
```

#### Add java bucket
```ps
PS C:\Users\Mambo> scoop bucket add java
```

#### Install java
```ps
PS C:\Users\Mambo> scoop search temurin17
Results from local buckets...

Name                  Version                  Source Binaries
----                  -------                  ------ --------
temurin17-jdk         17.0.9-9.1               java
temurin17-jre         17.0.9-9.1               java
temurin17-nightly-jdk 17.0.10-4.0.202311240109 java
temurin17-nightly-jre 17.0.10-4.0.202311240109 java

PS C:\Users\Mambo> scoop install temurin17-jdk
Installing 'temurin17-jdk' (17.0.9-9.1) [64bit] from java bucket
OpenJDK17U-jdk_x64_windows_hotspot_17.0.9_9.zip (181.1 MB) [==================================================] 100%
Checking hash of OpenJDK17U-jdk_x64_windows_hotspot_17.0.9_9.zip ... ok.
Extracting OpenJDK17U-jdk_x64_windows_hotspot_17.0.9_9.zip ... done.
Linking ~\scoop\apps\temurin17-jdk\current => ~\scoop\apps\temurin17-jdk\17.0.9-9.1
'temurin17-jdk' (17.0.9-9.1) was installed successfully!

PS C:\Users\Mambo> java --version
openjdk 17.0.9 2023-10-17
OpenJDK Runtime Environment Temurin-17.0.9+9 (build 17.0.9+9)
OpenJDK 64-Bit Server VM Temurin-17.0.9+9 (build 17.0.9+9, mixed mode, sharing)
```
