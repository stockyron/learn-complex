package com.rg.netty.custom.server;

import com.alibaba.fastjson.JSON;
import com.rg.netty.server.dto.WsMassage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *    
 *  *  
 *  * @Project: netty 
 *  * @Package: com.rg.netty 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年11月26日15:30   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Slf4j
public class NettyClient {

    public static ConcurrentMap<String, Channel> channelMap = new ConcurrentHashMap<>();

    public void start(InetSocketAddress socketAddress, WsMassage wsMassage) {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap()
                .group(group)
                //该参数的作用就是禁止使用Nagle算法，使用于小数据即时传输
                .option(ChannelOption.TCP_NODELAY, true)
                .channel(NioSocketChannel.class)
                .remoteAddress(socketAddress)
                .handler(new ChannelInitializer<SocketChannel>() {//客户端初始化器
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        //添加String编解码
                        socketChannel.pipeline().addLast("decoder", new StringDecoder());
                        socketChannel.pipeline().addLast("encoder", new StringEncoder());
                        socketChannel.pipeline().addLast(new SimpleNettyClientHandler());
                    }
                });
        try {
            ChannelFuture future = bootstrap.connect().sync();
            log.info("客户端启动成功....");
            //发送消息
            if(wsMassage != null){
                future.channel().writeAndFlush(JSON.toJSONString(wsMassage));
                channelMap.put(wsMassage.getUserCode(), future.channel());
            }
            // 等待连接被关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

}
