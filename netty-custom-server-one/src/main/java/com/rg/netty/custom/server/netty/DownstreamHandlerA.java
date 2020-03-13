package com.rg.netty.custom.server.netty;

import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelDownstreamHandler;

@Slf4j
public class DownstreamHandlerA extends SimpleChannelDownstreamHandler {

  @Override
  public void writeRequested(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
    log.info("============DownstreamHandlerA 输出的内容是:{}", e.getMessage());
    super.writeRequested(ctx, e);
  }

  @Override
  public void handleDownstream(ChannelHandlerContext ctx, ChannelEvent e)
      throws Exception {
    System.out.println("====DownstreamHandlerA.handleDownstream " + e.getChannel().getRemoteAddress());
    log.info("DownstreamHandlerA 输出内容={}", e);
    //ctx.sendDownstream(new DownstreamMessageEvent(ctx.getChannel(),e.getFuture(),"client ===========", ctx.getChannel().getRemoteAddress()));
    super.handleDownstream(ctx, e);
  }

}
