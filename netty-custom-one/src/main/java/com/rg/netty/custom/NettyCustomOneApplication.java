package com.rg.netty.custom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;


@SpringBootApplication
public class NettyCustomOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(NettyCustomOneApplication.class, args);
        //启动netty客户端
        NettyClient nettyClient = new NettyClient();
        nettyClient.start(new InetSocketAddress("localhost", 8090), null);
    }

}
