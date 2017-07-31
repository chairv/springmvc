package netty.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * Created by tancw on 2017/7/31.
 */
public class HttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private final String wsuri;

    public HttpRequestHandler(String wsuri) {
        this.wsuri = wsuri;
    }


    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, FullHttpRequest request) throws Exception {

    }
}
