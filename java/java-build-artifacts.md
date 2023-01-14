## Build Artifacts

#### Use Intellij IDEA

Intellij IDEA > File > Project Structure > Artifacts

![](./img/01.png)  

Artifacts > Add JAR > From modules with dependencies...

![](./img/02.png)  
![](./img/03.png)  
![](./img/04.png)  

Build > artifacts > module-name:jar > Build 를 수행하면 out/artifacts 폴더에 jar 파일이 만들어진다.

![](./img/05.png)  
![](./img/06.png)  
![](./img/07.png)  

#### Use Maven JAR Plugin

Maven 으로 :jar 명령어를 수행하면 target 폴더에 jar 파일이 생성된다.

![](./img/08.png)  
![](./img/09.png)  
