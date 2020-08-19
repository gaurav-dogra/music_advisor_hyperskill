package advisor;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Auth extends SpotifyPlayerAction {
    @Override
    public void act() {
        createHttpServer();
        System.out.print("https://accounts.spotify.com/authorize?client_id=" +
                "4a6790355b57464dadabd7a7285e6d0f&redirect_uri=http://localhost:8080&response_type=code\n" +
                "waiting for code...\n");
    }

    private void createHttpServer() {
        try {
            HttpServer server = HttpServer.create();
            server.bind(new InetSocketAddress(8080), 0);
            server.createContext("/", httpExchange -> {
                String hello = "hello, world";
                httpExchange.sendResponseHeaders(200, hello.length());
                httpExchange.getResponseBody().write(hello.getBytes());
                httpExchange.getResponseBody().close();
            });
            server.start();
        } catch (IOException e) {
            System.out.println("Error while creating HTTP Server");
        }
    }
}
