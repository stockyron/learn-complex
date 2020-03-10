package com.rg.aop.aspectj;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.aop 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月31日18:33   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Slf4j
public class main {

    public static void main(String[] args) {
        //读取配置文件,加载 spring-bean.xml 文件，读取配置对应的 类
        ApplicationContext bf = new ClassPathXmlApplicationContext("spring-bean.xml");
        TestBean b = (TestBean) bf.getBean("test");
        b.test();
    }

}
