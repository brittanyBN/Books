package org.example;

import org.example.resource.BookResource;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.net.URI;


public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    public static final URI BASE_URI = URI.create("http://0.0.0.0:8080");

    public static void main(String[] args) {
        ResourceConfig config = new ResourceConfig();
        config.register(BookResource.class);
        HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, config);

    }
}