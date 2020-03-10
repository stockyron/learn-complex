package com.rg.netty.server.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.oio.OioDatagramChannel;

import java.net.InetSocketAddress;

/**
 *    
 *  *  
 *  * @Project: netty 
 *  * @Package: com.rg.netty.server.demo 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年11月28日15:31   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class demo2 {

    public static void main(String[] args) {
        Bootstrap b = new Bootstrap();
        b.group(new OioEventLoopGroup()).channel(OioDatagramChannel.class)
                .handler(new SimpleChannelInboundHandler<DatagramPacket>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg)
                            throws Exception {
                        // do something with the packet
                    }
                });
        ChannelFuture f = b.bind(new InetSocketAddress(0));
        f.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("Channel bound");
                } else {
                    System.err.println("Bound attempt failed");
                    future.cause().printStackTrace();
                }
            }
        });
    }


}
