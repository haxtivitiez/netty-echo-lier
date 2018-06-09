package netty.echo.lier.netty.echo.lier.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    private InternalLogger logger = InternalLoggerFactory.getInstance(getClass());

    private final ByteBuf respMessage;

    public EchoServerHandler() {
        String str = "I am Server, and I got your message.";
        respMessage = Unpooled.buffer(str.length());
        respMessage.writeBytes(str.getBytes());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ctx.write(respMessage);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }



}
