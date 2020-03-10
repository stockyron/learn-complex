package com.rg.jms.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.jms.spring 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月08日12:30   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class MyMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;

        try {
            System.out.println("MyMessageListener received msg is " + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
