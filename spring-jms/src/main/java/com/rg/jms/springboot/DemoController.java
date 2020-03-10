package com.rg.jms.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.TextMessage;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.jms.springboot 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月08日11:51   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@RestController
public class DemoController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/send")
    public void send(String msg){
        jmsTemplate.send("hello", session ->
            session.createTextMessage(msg)
        );
    }

}
