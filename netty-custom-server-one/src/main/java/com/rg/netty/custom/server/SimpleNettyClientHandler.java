package com.rg.netty.custom.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 *    
 *  *  
 *  * @Project: netty 
 *  * @Package: com.rg.netty 
 *  * @Description: TODO  客户端处理器 
 *  * @Author:   horus   
 *  * @CreateDate:  2019年11月26日15:29   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Slf4j
public class SimpleNettyClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("客户端Active .....{}", ctx.channel().id());
        ctx.writeAndFlush("netty-custom-server连接成功");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        log.info("客户端收到消息: {}", msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
