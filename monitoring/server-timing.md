## Server Timing API

크롬 브라우저에서 첫 패킷을 받기까지의 시간을 기본적으로 제공하는데 [Server Timing](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Server-Timing) API 를 통해 서버는 구간별 소요시간(ms)을 제공하면 브라우저에서 이를 확인할 수 있다.

```http
Server-Timing: Exec;dur=30
```

```java
@ControllerAdvice
public class ServerTimingAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        ServletServerHttpRequest servletServerRequest = (ServletServerHttpRequest) request;
        Object startTime = servletServerRequest.getServletRequest().getAttribute(ServerTimingInterceptor.START);
        if (startTime == null) {
            return body;
        }
        long timeElapsed = System.currentTimeMillis() - (long) startTime;
        response.getHeaders().add(HttpHeaders.SERVER_TIMING, "Exec;dur=" + timeElapsed);
        return body;
    }
}

@Component
public class ServerTimingInterceptor implements HandlerInterceptor {
    public static final String START = "SERVER_TIMING_START";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute(START, System.currentTimeMillis());
        return true;
    }
}
```

