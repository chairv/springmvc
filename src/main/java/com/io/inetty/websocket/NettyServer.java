package com.io.inetty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by tancw on 2017/6/9.
 */
public class NettyServer {
    public static void main(String[] args) {
        new NettyServer().run();
    }

    public void run() {
        EventLoopGroup bossGroup = new NioEventLoopGroup(); //用来接收进来的连接
        EventLoopGroup workGroup = new NioEventLoopGroup(); //用来处理已经被接收的连接

        try {
            ServerBootstrap b = new ServerBootstrap();  //启动NIO服务的辅助启动类
            b.group(bossGroup, workGroup);
            b.channel(NioServerSocketChannel.class);
            b.childHandler(new ChildChannelHandler());
            System.out.println("服务端开启等待客户端连接........");
            Channel ch = b.bind(7397).sync().channel();
            ch.closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }
}
