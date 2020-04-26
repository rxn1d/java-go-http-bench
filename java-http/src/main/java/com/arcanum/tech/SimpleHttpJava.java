package com.arcanum.tech;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SimpleHttpJava {
    static final HttpHandler HANDLER = (HttpExchange exchange) -> {
        byte[] queryBytes = exchange.getRequestURI().getRawQuery().getBytes();
        byte[] requestBytes = exchange.getRequestBody().readAllBytes();

        byte[] response = new byte[queryBytes.length + requestBytes.length];
        int responseSize = queryBytes.length + requestBytes.length;

        System.arraycopy(queryBytes, 0, response, 0, queryBytes.length);
        System.arraycopy(requestBytes, 0, response, queryBytes.length, requestBytes.length);

        exchange.sendResponseHeaders(200, responseSize);

        exchange.getResponseBody().write(response);
        exchange.getResponseBody().flush();

        exchange.close();
    };

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/bench", HANDLER);
        server.setExecutor(null); // creates a default executor
        server.start();
    }
}

