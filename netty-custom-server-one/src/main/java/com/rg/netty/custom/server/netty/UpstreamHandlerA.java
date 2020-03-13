package com.rg.netty.custom.server.netty;

import lombok.extern.slf4j.Slf4j;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 * @author bill
 */
@Slf4j
public class UpstreamHandlerA extends SimpleChannelHandler {

  //private final ChannelGroup allOpenChannels = new DefaultChannelGroup();

  /*@Override
  public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e){
    log.info("channel connected {}", ctx.getChannel());
    allOpenChannels.add(ctx.getChannel());
  }*/

  /**
   * 添加到 group 中
   * @param ctx
   * @param e
   * @throws Exception
   */
  @Override
  public void handleUpstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
    //log.info("handle 添加到 group 中");
    //allOpenChannels.add(e.getChannel());
    //super.handleUpstream(ctx, e);
  }

  @Override
  public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {

    System.out
        .println("=================UpstreamHandlerA.messageReceived:" + e.getMessage().toString());

    log.info("RemoteAddress = {}", e.getRemoteAddress());
    log.info("getName = {} " , ctx.getName());
    log.info("=========服务器收到{}, 消息内容={}", e.getChannel().getId(),  e.getMessage());

    //回复数据
    ChannelBuffer channelBuffer = ChannelBuffers.copiedBuffer("UpstreamHandlerA Server return...".getBytes());
    ctx.getChannel().write(channelBuffer);

    super.messageReceived(ctx, e);
  }

  /**
   * 异常捕获
   * @param ctx
   * @param e
   */
  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
    System.out.println("UpstreamHandlerA.exceptionCaught:" + e.toString());
    e.getChannel().close();
  }

  /**
   * 新连接
   */
  @Override
  public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception{
    log.info("UpstreamHandlerA.......开始连接");
    super.channelConnected(ctx, e);
  }

  /**
   * 必须是链接已经建立，关闭通道的时候才会触发
   */
  @Override
  public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
    System.out.println("channelDisconnected");
    super.channelDisconnected(ctx, e);
  }

  /**
   * channel关闭的时候触发
   */
  @Override
  public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
    System.out.println("channelClosed");
    super.channelClosed(ctx, e);
  }

}
