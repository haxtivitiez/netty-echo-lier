package netty.echo.lier.netty.echo.lier.client;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Sends one message when a connection is open and echoes back any received
 * data to the server.  Simply put, the echo client initiates the ping-pong
 * traffic between the echo client and server by sending the first message to
 * the server.
 */

public class EchoClient {

    private int port;
    private String host;

    public void startClient(String host, int port){
        this.host = host;
        this.port = port;

        // Configure the client.
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .handler(new EchoClientInitializer());
            // Start the client.
            ChannelFuture f = b.connect(this.host, this.port).sync();
            // Wait until the connection is closed.
            f.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // Shut down the event loop to terminate all threads.
            group.shutdownGracefully();
        }

    }
}
