package com.io.inetty.comm;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * Created by tancw on 2017/6/9.
 * server
 */
public class Global {
     public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
