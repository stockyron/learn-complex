package com.rg.bean.XmlApplicationContext.listener;

import org.springframework.context.ApplicationListener;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.XmlApplicationContext.listener 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月31日14:27   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class TestListener implements ApplicationListener<TestEvent> {

    @Override
    public void onApplicationEvent(TestEvent testEvent) {
        testEvent.print();
    }

}
