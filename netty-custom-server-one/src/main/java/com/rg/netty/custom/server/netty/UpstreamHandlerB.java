package com.rg.netty.custom.server.netty;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;

/**
 * @author bill
 */
public class UpstreamHandlerB extends SimpleChannelUpstreamHandler {

  /**
   * 已经收到信息
   * @param ctx
   * @param e
   * @throws Exception
   */
  @Override
  public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {

    System.out
        .println("=============UpstreamHandler====B.messageReceived：" + e.getMessage());

    //回复数据
    ChannelBuffer channelBuffer = ChannelBuffers.copiedBuffer("UpstreamHandlerB return hi#########".getBytes());
    ctx.getChannel().write(channelBuffer);

    super.messageReceived(ctx, e);

  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
    System.out.println("UpstreamHandler===B.exceptionCaught：" + e.toString());
    e.getChannel().close();
  }

}
