package netty.echo.lier;

import netty.echo.lier.netty.echo.lier.client.EchoClient;
import netty.echo.lier.netty.echo.lier.properties.Properties;

public class Client {
    public static void main(String[] args) {
        new EchoClient().startClient(Properties.HOST,Properties.PORT);
    }
}
