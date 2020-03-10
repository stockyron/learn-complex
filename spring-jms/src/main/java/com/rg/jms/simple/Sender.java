package com.rg.jms.simple;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.TimeUnit;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.jms 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月08日11:20   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class Sender {

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        Connection connection = connectionFactory.createConnection();
        //connection.start();
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("my-queue");

        MessageProducer producer = session.createProducer(destination);
        for (int i = 0; i < 3; i++) {
            TextMessage message = session.createTextMessage("大家好这是个测试" + i);
            TimeUnit.SECONDS.sleep(1);
            producer.send(message);
        }
        session.commit();
        session.close();
        connection.close();
    }

}
