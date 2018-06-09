package netty.echo.lier.netty.echo.lier.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import netty.echo.lier.netty.echo.lier.properties.Properties;

public class EchoClientHandler extends ChannelInboundHandlerAdapter {

    private InternalLogger logger = InternalLoggerFactory.getInstance(getClass());
    private final ByteBuf reqMessage;


    public EchoClientHandler() {
        String str = "I am Client. Hello Server!";
        reqMessage = Unpooled.buffer(Properties.SIZE);
        reqMessage.writeBytes(str.getBytes());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(reqMessage);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        int len = in.readableBytes();
        byte[] bytes = new byte[len];
        in.readBytes(bytes);
        logger.info("msg from server: " + new String(bytes));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
