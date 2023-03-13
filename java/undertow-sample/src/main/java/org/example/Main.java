package org.example;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.UndertowLogger;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import io.undertow.util.Headers;
import jakarta.servlet.ServletException;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws ServletException {
        DeploymentInfo deployment = Servlets.deployment()
                .setClassLoader(Main.class.getClassLoader())
                .setContextPath("/")
                .setDeploymentName("main.war")
                .addServletExtension((deploymentInfo, servletContext) ->
                        deploymentInfo.addInitialHandlerChainWrapper(handler ->
                                Handlers.path().addPrefixPath("/", exchange -> {
                                    Optional<String> clientIp = IpUtil.getClientIp(exchange);
                                    UndertowLogger.REQUEST_LOGGER.info("clientIp: " + clientIp.orElseThrow());

                                    exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                                    exchange.getResponseSender().send("Hello World");
                                    System.out.println("Hello World");
                                })))
                .setDefaultEncoding(StandardCharsets.UTF_8.name());

        DeploymentManager manager = Servlets.defaultContainer().addDeployment(deployment);
        manager.deploy();

        Undertow server = Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(Handlers.path()
                        .addExactPath("/", manager.start()))
                .build();
        server.start();
    }
}