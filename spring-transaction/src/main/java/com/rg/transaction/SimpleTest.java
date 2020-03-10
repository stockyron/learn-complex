package com.rg.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.jdbc 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月02日18:53   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class SimpleTest {

    public static void main(String[] args) throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = (UserService) ac.getBean("userService");
        User user = new User();
        user.setName("七七");
        user.setAge(29);
        user.setSex("男");
        userService.save(user);

    }

}
