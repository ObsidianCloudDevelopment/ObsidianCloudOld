package de.obsidiancloud.master.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.util.concurrent.GlobalEventExecutor;

public class NettyServer {
    public static EventLoopGroup bossGroup;
    public static EventLoopGroup workerGroup;

    public static final ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public static void start() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                bossGroup = new NioEventLoopGroup();
                workerGroup = new NioEventLoopGroup();
                try {
                    ServerBootstrap serverBootstrap = new ServerBootstrap()
                            .group(bossGroup)
                            .channel(NioServerSocketChannel.class)
                            .childHandler(new ChannelInitializer<SocketChannel>() {
                                protected void initChannel(SocketChannel socketChannel) {
                                    ChannelPipeline channelPipeline = socketChannel.pipeline();
                                    channelPipeline.addLast("packetEncoder", new ObjectEncoder());
                                    channelPipeline.addLast("packetDecoder", new ObjectDecoder(ClassResolvers.cacheDisabled(getClass().getClassLoader())));
                                    channelPipeline.addLast("auth", (ChannelHandler) new NettyHandler());
                                    channelPipeline.addLast("packetHandler", new PacketHandler());
                                }
                            });

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

}
