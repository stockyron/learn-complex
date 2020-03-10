package com.rg.bean.XmlApplicationContext.listener;

import com.rg.bean.XmlApplicationContext.MyClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.XmlApplicationContext.listener 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月31日14:31   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class ListenerMain {


    public static void main(String[] args) {
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestEvent event = new TestEvent("hello", "msg000");

        act.publishEvent(event);
    }

}
