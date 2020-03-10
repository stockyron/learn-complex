package com.rg.jms.springboot;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.jms.simple 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月08日11:46   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Service
public class ActiveListener {

    @JmsListener(destination = "my-queue")
    public void msg1(String message){
        System.out.println("------监听到activemq【my-queue】的数据"+message);
    }

    @JmsListener(destination = "hello")
    public void msg2(String message){
        System.out.println("------监听到activemq【hello】的数据"+message);
    }

}
