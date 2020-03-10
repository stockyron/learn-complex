package com.rg.netty.server;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.rg.netty.server.dto.WsMassage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *    
 *  *  
 *  * @Project: netty 
 *  * @Package: com.rg.netty 
 *  * @Description: TODO   netty服务端处理器
 *  * @Author:   horus   
 *  * @CreateDate:  2019年11月25日17:40   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Slf4j
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 存放所有的channel
     */
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 存放通道channel与用户之间的关系
     */
    private static ConcurrentMap<String, ChannelId> channelMap = new ConcurrentHashMap<>();

    /**
     * 客户端连接会触发
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("Channel active......{}", ctx.channel().id());
        channelGroup.add(ctx.channel());
    }

    /**
     * 客户端发消息会触发
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg != null){
            log.info("服务器收到消息: {}", msg.toString());
            try {
                WsMassage<String> wsMassage = JSONArray.parseObject(msg.toString(), WsMassage.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ctx.writeAndFlush("服务器端收到消息");
        } else {
            ctx.writeAndFlush("客服端消息不能为空");
        }
    }

    /**
     * 客户端发消息后消息被处理完毕后会触发
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    /**
     * 发生异常触发
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
