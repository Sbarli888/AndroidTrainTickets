package com.example;

import com.example.mysql.MySQLManager;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;

public class Main {

    public static final String BASE_URI = "http://localhost:8080/api/";
    private static Logger logger;

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.example package
        final ResourceConfig rc = new ResourceConfig().packages("com.example");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args String[]
     */
    public static void main(String[] args) throws IOException {
        logger = Logger.getLogger(Main.class.getName());
        final HttpServer server = startServer();

        MySQLManager.init();
        logger.info("Jersey Server has started...");
        logger.info("URL: " + BASE_URI);

        // end connection
        System.in.read();
        server.shutdownNow();
    }

    /**
     * Get console logger
     * @return logger
     */
    public static Logger getLogger() {
        return logger;
    }
}