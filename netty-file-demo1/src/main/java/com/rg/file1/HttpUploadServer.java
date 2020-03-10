package com.rg.file1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;

/**
 *    
 *  *  
 *  * @Project: netty 
 *  * @Package: com.rg.file1 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年11月28日11:22   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class HttpUploadServer {

    static final boolean SSL = System.getProperty("ssl") != null;

    static final int PORT = Integer.parseInt(System.getProperty("port", SSL ? "8443" : "8080"));

    public static void main(String[] args) throws Exception {
        // Configure SSL.
        final SslContext sslCtx;
        if (SSL) {
            SelfSignedCertificate ssc = new SelfSignedCertificate();
            sslCtx = SslContextBuilder.forServer(ssc.certificate(), ssc.privateKey()).build();
        } else {
            sslCtx = null;
        }

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {

            ServerBootstrap b = new ServerBootstrap();

            b.group(bossGroup, workerGroup);

            b.channel(NioServerSocketChannel.class);

            b.handler(new LoggingHandler(LogLevel.INFO));

            b.childHandler(new ChannelInitializer<SocketChannel>(){
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    if (sslCtx != null) {
                        pipeline.addLast(sslCtx.newHandler(ch.alloc()));
                    }
                    pipeline.addLast(new HttpRequestDecoder());
                    pipeline.addLast(new HttpResponseEncoder());
                    // Remove the following line if you don't want automatic content compression.
                    pipeline.addLast(new HttpContentCompressor());
//        pipeline.addLast("http-aggregator",
//                new HttpObjectAggregator(65536));// 目的是将多个消息转换为单一的request或者response对象
                    pipeline.addLast(new HttpUploadServerHandler());
                }
            });

            Channel ch = b.bind(PORT).sync().channel();

            System.err.println("Open your web browser and navigate to " +
                    (SSL ? "https" : "http") + "://127.0.0.1:" + PORT + '/');

            ch.closeFuture().sync();

        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}
