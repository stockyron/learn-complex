package com.rg.netty.custom.server.netty;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;

public class UpstreamHandlerX extends SimpleChannelUpstreamHandler {

  @Override
  public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
      throws Exception {
    System.out.println("================UpstreamHandler=====X.messageReceived");

    //回复数据
    ChannelBuffer channelBuffer = ChannelBuffers.copiedBuffer("UpstreamHandlerX return hi...".getBytes());
    ctx.getChannel().write(channelBuffer);

    super.messageReceived(ctx, e);
    //e.getChannel().write(e.getMessage());// (2)
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
    System.out.println("UpstreamHandlerX.exceptionCaught");
    e.getChannel().close();
  }

}
