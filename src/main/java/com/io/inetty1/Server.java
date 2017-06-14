package com.io.inetty1;

import java.util.concurrent.Executors;

import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import io.netty.bootstrap.ServerBootstrap;

/**
 * Created by tancw on 2017/6/13.
 */
public class Server {
    public static void main(String[] args) {
        /**
         * 1 channelFacotry是一个创建和管理Channel通道及其相关资源的工厂接口
         * 它处理所有的I/O请求并产生相应的I/O ChannelEvent通道事件
         */
        ChannelFactory factory = new NioServerSocketChannelFactory(Executors.newCachedThreadPool(),Executors.newCachedThreadPool());
        /**
         * ServerBootStrap 是一个设置服务的帮助类
         *
         */
        ServerBootstrap s = new ServerBootstrap();

    }
}
