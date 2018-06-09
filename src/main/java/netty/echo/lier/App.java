package netty.echo.lier;

import netty.echo.lier.netty.echo.lier.client.EchoClient;
import netty.echo.lier.netty.echo.lier.properties.Properties;
import netty.echo.lier.netty.echo.lier.server.EchoServer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {

        new EchoServer().startServer();

    }
}
