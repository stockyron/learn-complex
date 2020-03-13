package com.rg.netty.custom.server.netty;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.execution.ExecutionHandler;
import org.jboss.netty.handler.execution.OrderedMemoryAwareThreadPoolExecutor;

public class PipelineFactoryTest implements ChannelPipelineFactory {

  @Override
  public ChannelPipeline getPipeline() throws Exception {
    ChannelPipeline pipeline = Channels.pipeline();
    pipeline.addLast("executor", new ExecutionHandler(
        new OrderedMemoryAwareThreadPoolExecutor(2, 1048576, 1048576)));
    pipeline.addLast("1", new UpstreamHandlerA());
    pipeline.addLast("2", new UpstreamHandlerB());
    pipeline.addLast("3", new DownstreamHandlerA());
    pipeline.addLast("4", new DownstreamHandlerB());
    pipeline.addLast("5", new UpstreamHandlerX());
    return pipeline;

   /* ChannelPipeline pipeline = Channels.pipeline();
    pipeline.addLast("executor", new ExecutionHandler(
        new OrderedMemoryAwareThreadPoolExecutor(4, 1048576, 1048576)));
    pipeline.addLast("frameDecoder", new ProtobufVarint32FrameDecoder());
    //ret.addLast("protobufDecoder",
    //    new ProtobufDecoder(GameMsg.getDefaultInstance()));
    pipeline.addLast("frameEncoder", new ProtobufVarint32LengthFieldPrepender());
    pipeline.addLast("protobufEncoder", new ProtobufEncoder());
    //pipeline.addLast("1", new UpstreamHandlerA());
    pipeline.addLast("handler", new UpstreamHandlerA());
    return pipeline;*/
  }

}
