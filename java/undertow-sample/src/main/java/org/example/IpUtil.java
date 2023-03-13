package org.example;

import com.google.common.net.InetAddresses;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HeaderMap;
import io.undertow.util.HeaderValues;

import java.util.Optional;

public class IpUtil {
    public static final String HTTP_HEADER_XFF = "X-Forwarded-For";

    private IpUtil() {
    }

    public static Optional<String> getClientIp(HttpServerExchange exchange) {
        if (exchange == null) {
            return Optional.empty();
        }

        HeaderMap requestHeaders = exchange.getRequestHeaders();
        HeaderValues xff = requestHeaders.get(HTTP_HEADER_XFF);
        if (xff != null && !xff.isEmpty()) {
            return xff.stream()
                    .map(String::trim)
                    .filter(InetAddresses::isInetAddress)
                    .findFirst();
        }

        return Optional.of(InetAddresses.toAddrString(exchange.getSourceAddress().getAddress()));
    }


}