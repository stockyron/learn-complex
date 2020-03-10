package com.rg.mvc.simple;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.mvc.simple 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月06日13:21   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class MyDataContextListener implements ServletContextListener {

    private ServletContext context;

    //该方法在ServletContext启动之后被调用，并准备好处理客户端请求
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.context = sce.getServletContext();
        context.setAttribute("myData", "this is myData");
    }

    //这个方法在ServletContext将要关闭的时候调用
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        this.context = null;
    }
}
