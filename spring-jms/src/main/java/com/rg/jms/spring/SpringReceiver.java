package com.rg.jms.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.jms.spring 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月08日12:27   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class SpringReceiver {

    public static void main(String[] args) throws JMSException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        JmsTemplate jmsTemplate = ac.getBean("jmsTemplate", JmsTemplate.class);
        Destination destination = ac.getBean("destination", Destination.class);

        TextMessage msg = (TextMessage) jmsTemplate.receive(destination);
        System.out.println("received msg is " + msg.getText());
    }
}
