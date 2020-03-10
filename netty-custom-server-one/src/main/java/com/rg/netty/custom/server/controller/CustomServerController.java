package com.rg.netty.custom.server.controller;

import com.rg.netty.custom.server.NettyClient;
import com.rg.netty.custom.server.dto.OnlineDto;
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
 *  * @Package: com.rg.netty.custom.server.controller 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年11月27日14:46   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Slf4j
@RestController
public class CustomServerController {

    @GetMapping("online")
    public OnlineDto online(HttpServletRequest request){
        try {
            String id = request.getSession().getId();
            WsMassage<String> wsMassage = new WsMassage<>();
            wsMassage.setType(WsMassage.TYPE_SERVER_ONLINE);
            wsMassage.setSystemCode(WsMassage.SYSYTEM_CODE_CALL_CENTER);
            wsMassage.setUserCode(id);

            //启动netty客户端
            new Thread(() -> {
                NettyClient nettyClient = new NettyClient();
                nettyClient.start(new InetSocketAddress("localhost", 8090), wsMassage);
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
