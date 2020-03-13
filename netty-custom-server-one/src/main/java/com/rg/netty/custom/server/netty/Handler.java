package com.rg.netty.custom.server.netty;

import lombok.extern.slf4j.Slf4j;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.channel.WriteCompletionEvent;

/**
 * org.jboss.netty.channel.ChannelHandler
 */
@Slf4j
public class Handler extends SimpleChannelHandler {


  @Override
  public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
    log.info("Handler 类开始执行.............");
    log.info("内容 = {} " , e.getMessage());
    super.messageReceived(ctx, e);
  }

  @Override
  public void writeComplete(ChannelHandlerContext ctx, WriteCompletionEvent e) throws Exception {
    log.info("Handler 输入的内容 = {}", e.getWrittenAmount());
    ctx.sendUpstream(e);
  }

}
