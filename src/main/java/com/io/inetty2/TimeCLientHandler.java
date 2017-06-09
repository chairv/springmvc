package com.io.inetty2;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by tancw on 2017/6/9.
 * http://www.getsetter.cn/2014/07/15/netty5/
 */
public class TimeCLientHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf m = (ByteBuf) msg;
        try {
            long currentTimeMillis = (m.readUnsignedByte() - 2208988800L ) * 1000L;
            System.out.println(new Date(currentTimeMillis));
            ctx.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            m.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
