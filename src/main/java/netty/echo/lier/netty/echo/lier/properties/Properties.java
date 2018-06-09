package netty.echo.lier.netty.echo.lier.properties;

public class Properties {

    public static final boolean SSL = System.getProperty("ssl") != null;
    public static final String HOST = System.getProperty("host", "127.0.0.1");
    public static final int PORT = Integer.parseInt(System.getProperty("port", "8007"));
    public static final int SIZE = Integer.parseInt(System.getProperty("size", "256"));
}
