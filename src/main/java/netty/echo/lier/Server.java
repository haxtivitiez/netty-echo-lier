package netty.echo.lier;

import netty.echo.lier.netty.echo.lier.server.EchoServer;

public class Server {
    public static void main(String[] args) throws InterruptedException {
        new EchoServer().startServer();
    }
}
