package com.rg.mvc.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.mvc.servlet 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月06日17:51   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@WebListener
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("MyListener contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("MyListener contextDestroyed");
    }
}
