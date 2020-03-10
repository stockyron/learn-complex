package com.rg.client.simple;

import com.rg.common.interfaces.HelloRMIService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.client.simple 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月07日20:39   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class ClientTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        HelloRMIService myClient = context.getBean("myClient", HelloRMIService.class);
        System.out.println(myClient.add(1, 2));
        System.out.println(myClient.minus(1, 2));
    }

}
