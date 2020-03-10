package com.rg.jms.simple;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.jms.simple 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月08日12:03   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class Receiver {

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("my-queue");

        MessageConsumer consumer = session.createConsumer(destination);
        for (int i = 0; i < 3; i++) {
            TextMessage message = (TextMessage) consumer.receive();
            session.commit();
            System.out.println("收到消息：" + message.getText());
        }
        session.close();
        connection.close();
    }

}
