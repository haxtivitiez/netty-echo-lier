package netty.echo.lier;

import netty.echo.lier.netty.echo.lier.client.EchoClient;
import netty.echo.lier.netty.echo.lier.properties.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        new EchoClient().start(Properties.HOST,Properties.PORT);
    }
}
