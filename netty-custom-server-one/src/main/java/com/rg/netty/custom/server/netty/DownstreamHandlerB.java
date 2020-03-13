package com.rg.netty.custom.server.netty;

import lombok.extern.slf4j.Slf4j;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelDownstreamHandler;

/**
 * @author bill
 */
@Slf4j
public class DownstreamHandlerB extends SimpleChannelDownstreamHandler {

  @Override
  public void handleDownstream(ChannelHandlerContext ctx, ChannelEvent e)
      throws Exception {
    System.out.println("DownstreamHandlerB.handleDownstream");
    super.handleDownstream(ctx, e);
  }

  @Override
  public void writeRequested(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
    log.info("DownstreamHandlerB ===== {} ", e.getMessage() );
    super.writeRequested(ctx, e);
  }

}
