package com.rg.netty.custom.controller;

import com.rg.netty.custom.NettyClient;
import com.rg.netty.server.dto.WsMassage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetSocketAddress;

/**
 *    
 *  *  
 *  * @Project: netty 
 *  * @Package: com.rg.netty.controller 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年11月27日12:29   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Slf4j
@RestController
public class MsgController {

    @GetMapping("connect")
    public String connect(HttpServletRequest request, WsMassage<String> wsMassage){
        try {
            String id = request.getSession().getId();
            wsMassage.setUserCode(id);
            //启动netty客户端
            new Thread(() -> {
                NettyClient nettyClient = new NettyClient();
                nettyClient.start(new InetSocketAddress("localhost", 8090), wsMassage);
            }).start();
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    @GetMapping("msg")
    public String msg(HttpServletRequest request, String msg){
        String id = request.getSession().getId();
        if(NettyClient.channelMap.containsKey(id)){
            NettyClient.channelMap.get(id).writeAndFlush(msg);
            return "success";
        } else {
            return "fail";
        }
    }

}
