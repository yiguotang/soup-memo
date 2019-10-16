package com.soup.memo.netty.multiconnect;

import lombok.extern.slf4j.Slf4j;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * <p>
 * Description: server的handler
 * </p>
 *
 * @author zhaoyi
 * @date 2019-01-04 10:56
 */
@Slf4j
public class ChartServerHandler extends SimpleChannelInboundHandler<String> {

    /**
     * 存储所有已连接client端的channel
     */
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.forEach(ch -> {
            if (channel != ch) {
                ch.writeAndFlush(channel.remoteAddress() + " send msg: " + msg + "\n");
            } else {
                ch.writeAndFlush("[self] " + msg + "\n");
            }
        });
    }

    /**
     * 当client与server连接建立好
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        // 获取channel
        Channel channel = ctx.channel();
        // 告诉其他连接我已经加入，即为一种广播消息，向ChannelGroup发送消息
        channelGroup.writeAndFlush("[Server] - " + channel.remoteAddress() + " added!\n");
        // 添加当前client的channel添加到ChannelGroup中
        channelGroup.add(channel);
    }

    /**
     * 当前连接断开
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        // 先移除当前client的channel从ChannelGroup中移除，netty是自动进行处理，可以不处理
        // channelGroup.remove(channel);
        // 告诉其他连接我已经断开，即为一种广播消息，向ChannelGroup发送消息
        channelGroup.writeAndFlush("[Server] - " + channel.remoteAddress() + " removed!\n");

        log.info("channelGroup size: {}", channelGroup.size());
    }

    /**
     * 当前连接处于活动状态
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("{} online!", ctx.channel().remoteAddress());
    }

    /**
     * 当前连接处于不活动状态
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("{} offline!", ctx.channel().remoteAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.channel().close();
    }
}
