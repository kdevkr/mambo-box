## 언더토우 임시 디렉토리 오류

고객이 실제로 사용하는 환경에 실행된 시스템에서 파일 업로드 기능이 불가능한 상황이 발생했다. 파일 업로드를 수행하는 요청에 대해서 아래와 같은 런타임 예외가 발생했는데 이 사유에 대해서 정리해보고자 한다.

```java
java.lang.RuntimeException: java.nio.file.NoSuchFileException: /tmp/undertow.5000.14210196318133640644/undertow598150743763989657upload
```

더 자세한 스택트레이스는 다음과 같다.


```java
org.springframework.web.multipart.MultipartException: Failed to parse multipart servlet request; nested exception is java.lang.RuntimeException: java.nio.file.NoSuchFileException: /tmp/undertow.5000.14210196318133640644/undertow598150743763989657upload
	at org.springframework.web.multipart.support.StandardMultipartHttpServletRequest.handleParseFailure(StandardMultipartHttpServletRequest.java:124)
	at org.springframework.web.multipart.support.StandardMultipartHttpServletRequest.parseRequest(StandardMultipartHttpServletRequest.java:115)
	at org.springframework.web.multipart.support.StandardMultipartHttpServletRequest.<init>(StandardMultipartHttpServletRequest.java:88)
	at org.springframework.web.multipart.support.StandardServletMultipartResolver.resolveMultipart(StandardServletMultipartResolver.java:87)
	at org.springframework.web.servlet.DispatcherServlet.checkMultipart(DispatcherServlet.java:1199)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1033)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:517)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:584)
	at io.undertow.servlet.handlers.ServletHandler.handleRequest(ServletHandler.java:74)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:129)
	at me.ymq.starterapi.filter.ReplaceStreamFilter.doFilter(ReplaceStreamFilter.java:33)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:61)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:61)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:61)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.boot.actuate.metrics.web.servlet.WebMvcMetricsFilter.doFilterInternal(WebMvcMetricsFilter.java:93)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:61)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:61)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at io.undertow.servlet.handlers.FilterHandler.handleRequest(FilterHandler.java:84)
	at io.undertow.servlet.handlers.security.ServletSecurityRoleHandler.handleRequest(ServletSecurityRoleHandler.java:62)
	at io.undertow.servlet.handlers.ServletChain$1.handleRequest(ServletChain.java:68)
	at io.undertow.servlet.handlers.ServletDispatchingHandler.handleRequest(ServletDispatchingHandler.java:36)
	at io.undertow.servlet.handlers.RedirectDirHandler.handleRequest(RedirectDirHandler.java:68)
	at io.undertow.servlet.handlers.security.SSLInformationAssociationHandler.handleRequest(SSLInformationAssociationHandler.java:132)
	at io.undertow.servlet.handlers.security.ServletAuthenticationCallHandler.handleRequest(ServletAuthenticationCallHandler.java:57)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.security.handlers.AbstractConfidentialityHandler.handleRequest(AbstractConfidentialityHandler.java:46)
	at io.undertow.servlet.handlers.security.ServletConfidentialityConstraintHandler.handleRequest(ServletConfidentialityConstraintHandler.java:64)
	at io.undertow.security.handlers.AuthenticationMechanismsHandler.handleRequest(AuthenticationMechanismsHandler.java:60)
	at io.undertow.servlet.handlers.security.CachedAuthenticatedSessionHandler.handleRequest(CachedAuthenticatedSessionHandler.java:77)
	at io.undertow.security.handlers.AbstractSecurityContextAssociationHandler.handleRequest(AbstractSecurityContextAssociationHandler.java:43)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.SendErrorPageHandler.handleRequest(SendErrorPageHandler.java:52)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.ServletInitialHandler.handleFirstRequest(ServletInitialHandler.java:269)
	at io.undertow.servlet.handlers.ServletInitialHandler.access$100(ServletInitialHandler.java:78)
	at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:133)
	at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:130)
	at io.undertow.servlet.core.ServletRequestContextThreadSetupAction$1.call(ServletRequestContextThreadSetupAction.java:48)
	at io.undertow.servlet.core.ContextClassLoaderSetupAction$1.call(ContextClassLoaderSetupAction.java:43)
	at io.undertow.servlet.handlers.ServletInitialHandler.dispatchRequest(ServletInitialHandler.java:249)
	at io.undertow.servlet.handlers.ServletInitialHandler.access$000(ServletInitialHandler.java:78)
	at io.undertow.servlet.handlers.ServletInitialHandler$1.handleRequest(ServletInitialHandler.java:99)
	at io.undertow.server.Connectors.executeRootHandler(Connectors.java:387)
	at io.undertow.server.HttpServerExchange$1.run(HttpServerExchange.java:841)
	at org.jboss.threads.ContextClassLoaderSavingRunnable.run(ContextClassLoaderSavingRunnable.java:35)
	at org.jboss.threads.EnhancedQueueExecutor.safeRun(EnhancedQueueExecutor.java:2019)
	at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.doRunTask(EnhancedQueueExecutor.java:1558)
	at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1449)
	at java.base/java.lang.Thread.run(Thread.java:844)
Caused by: java.lang.RuntimeException: java.nio.file.NoSuchFileException: /tmp/undertow.5000.14210196318133640644/undertow598150743763989657upload
	at io.undertow.server.handlers.form.MultiPartParserDefinition$MultiPartUploadHandler.beginPart(MultiPartParserDefinition.java:261)
	at io.undertow.util.MultipartParser$ParseState.headerName(MultipartParser.java:208)
	at io.undertow.util.MultipartParser$ParseState.parse(MultipartParser.java:123)
	at io.undertow.server.handlers.form.MultiPartParserDefinition$MultiPartUploadHandler.parseBlocking(MultiPartParserDefinition.java:232)
	at io.undertow.servlet.spec.HttpServletRequestImpl.parseFormData(HttpServletRequestImpl.java:857)
	at io.undertow.servlet.spec.HttpServletRequestImpl.loadParts(HttpServletRequestImpl.java:579)
	at io.undertow.servlet.spec.HttpServletRequestImpl.getParts(HttpServletRequestImpl.java:530)
	at org.springframework.web.multipart.support.StandardMultipartHttpServletRequest.parseRequest(StandardMultipartHttpServletRequest.java:95)
	... 63 common frames omitted
Caused by: java.nio.file.NoSuchFileException: /tmp/undertow.5000.14210196318133640644/undertow598150743763989657upload
	at java.base/sun.nio.fs.UnixException.translateToIOException(UnixException.java:92)
	at java.base/sun.nio.fs.UnixException.rethrowAsIOException(UnixException.java:111)
	at java.base/sun.nio.fs.UnixException.rethrowAsIOException(UnixException.java:116)
	at java.base/sun.nio.fs.UnixFileSystemProvider.newByteChannel(UnixFileSystemProvider.java:215)
	at java.base/java.nio.file.Files.newByteChannel(Files.java:369)
	at java.base/java.nio.file.Files.createFile(Files.java:640)
	at java.base/java.nio.file.TempFileHelper.create(TempFileHelper.java:137)
	at java.base/java.nio.file.TempFileHelper.createTempFile(TempFileHelper.java:160)
	at java.base/java.nio.file.Files.createTempFile(Files.java:860)
	at io.undertow.server.handlers.form.MultiPartParserDefinition$MultiPartUploadHandler.beginPart(MultiPartParserDefinition.java:254)
	... 70 common frames omitted
```

스택트레이스에 따르면 언더토우의 MultiPartUploadHandler 클래스에서 임시 파일을 생성을 시도하는 과정에서 /tmp/undertow.5000.14210196318133640644/undertow598150743763989657upload 경로를 찾을 수 없었다는 메시지이다. 일반적으로 스프링 파일 업로드 시에는 임시 파일로 생성되고 이 파일을 멀티파트로 읽어들인 후 삭제한다고 알고 있었다.

그러나 이 임시 파일이 어디에 만들어지는지는 크게 신경쓰지 않았는데 스프링 부트에서는 멀티파트에 대한 경로가 지정되지 않으면 시스템의 **기본 임시 디렉토리**를 사용한다는 것을 인지해야한다.

```java
if(config.getLocation() == null || config.getLocation().isEmpty()) {
    tempDir = servletContext.getDeployment().getDeploymentInfo().getTempPath();
} else {
    String location = config.getLocation();
    Path locFile = Paths.get(location);
    if(locFile.isAbsolute()) {
        tempDir = locFile;
    } else {
        final DeploymentInfo deploymentInfo = servletContext.getDeployment().getDeploymentInfo();
        tempDir = deploymentInfo.requireTempPath().resolve(location);
    }
}
```

### 리눅스 시스템 임시 디렉토리
리눅스 시스템의 임시 디렉토리인 /tmp는 주기적으로 사용되지 않는 파일에 대해서 삭제하도록 되어있기 때문에 서버에서 일시적으로 만들어지는 파일을 이 경로에 생성해두고 사용한 후 별다른 관리를 하지 않는다. 앞서 스프링 부트에서 멀티파트 경로에 대해 지정하지 않으면 시스템의 기본 임시 디렉토리를 사용한다고 하였기에 언더토우에서는 /tmp/undertow.5000.XXX와 같은 경로에 디렉토리를 생성한 것이다.

고객 환경에서 이 문제가 발생한 이유는 시스템에서 파일 업로드 기능이 생각보다 자주 사용되지 않기 때문일 수 있다는 생각이든다. 고객 환경으로 패치되기 이전에 테스트 환경을 통해서 여러가지 기능 동작을 검증하기는 하지만 파일 업로드 기능에 대한 테스트를 수행하는 환경에서는 애플리케이션 서버에서 사용중인 파일 업로드 경로가 삭제되지 않았을 것이다.

이 문제를 해결하기 위한 대응책으로는 주기적으로 10일 이내에 애플리케이션 서버를 재실행하는 관리 정책을 가지거나 멀티파트에 대한 경로를 수동으로 지정하고나서 서버 시스템에 등록된 tmpwatch 또는 tmpfiles.d에 삭제해야하는 파일의 기간을 늘리는 방안이 있는 것으로 보인다.

애플리케이션 서버 내에서 주기적으로 언더토우가 바라보는 파일 업로드 임시 경로에 파일을 생성하고 삭제하는 스케줄을 구현해도 나쁘지는 않을 것 같다. 

### 관련 링크

- [tmpwatch](https://linux.die.net/man/8/tmpwatch)
- [tmpfiles.d](https://www.commandlinux.com/man-page/man5/tmpfiles.d.5.html)
- https://java.ihoney.pe.kr/489
- https://github.com/spring-projects/spring-boot/issues/9616