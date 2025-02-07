## InputStream to byte[]

```java
@RequestMapping(value = "/file", method = {RequestMethod.POST, RequestMethod.PUT})
public ResponseEntity<byte[]> upload(@RequestPart("file") MultipartFile file) throws IOException {
    file.getBytes(); // InputStream::readAllBytes since JDK 9+
    
    org.springframework.util.StreamUtils.copyToByteArray(file.getInputStream());
    org.apache.commons.io.IOUtils.toByteArray(file.getInputStream());
    com.google.common.io.ByteStreams.toByteArray(file.getInputStream());
    org.apache.poi.util.IOUtils.toByteArray(file.getInputStream());
    software.amazon.awssdk.utils.IoUtils.toByteArray(file.getInputStream());
}
```

- [StandardMultipartFile::getBytes](https://github.com/spring-projects/spring-framework/blob/main/spring-web/src/main/java/org/springframework/web/multipart/support/StandardMultipartHttpServletRequest.java#L254-L256)
- [org.springframework.util.FileCopyUtils.copyToByteArray](https://github.com/spring-projects/spring-framework/blob/main/spring-core/src/main/java/org/springframework/util/FileCopyUtils.java#L143-L151)
- [org.springframework.util.StreamUtils.copyToByteArray](https://github.com/spring-projects/spring-framework/blob/3fff3b8a6d25a82750e28e2cddb3d8680baa34b2/spring-core/src/main/java/org/springframework/util/StreamUtils.java#L62-L68)
- [org.apache.commons.io.IOUtils.toByteArray](https://github.com/apache/commons-io/blob/master/src/main/java/org/apache/commons/io/IOUtils.java#L2708-L2717)
- [com.google.common.io.ByteStreams.toByteArray](https://github.com/google/guava/blob/master/guava/src/com/google/common/io/ByteStreams.java#L240-L243)
- [org.apache.poi.util.IOUtils.toByteArray](https://github.com/apache/poi/blob/trunk/poi/src/main/java/org/apache/poi/util/IOUtils.java#L174-L176)
- [software.amazon.awssdk.utils.IoUtils.toByteArray](https://github.com/aws/aws-sdk-java-v2/blob/master/utils/src/main/java/software/amazon/awssdk/utils/IoUtils.java#L41-L50)
