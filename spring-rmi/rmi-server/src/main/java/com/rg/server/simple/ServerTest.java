package com.rg.server.simple;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.server.simple 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月07日20:32   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class ServerTest {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring.xml");
    }

}
