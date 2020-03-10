package com.rg.jms.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;


/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.jms.spring 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月08日12:17   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class SpringSender {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        JmsTemplate jmsTemplate = ac.getBean("jmsTemplate", JmsTemplate.class);
        Destination destination = ac.getBean("destination", Destination.class);
        jmsTemplate.send(destination, session ->
                session.createTextMessage("这是Spring整合ActiveMQ测试")
        );
    }


}
