package com.rg.bean.XmlApplicationContext.listener;

import org.springframework.context.ApplicationEvent;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.XmlApplicationContext.listener 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月31日14:25   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class TestEvent extends ApplicationEvent {

    public String msg;

    public TestEvent(Object source) {
        super(source);
    }

    public TestEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public void print(){
        System.out.println(msg);
    }
}
