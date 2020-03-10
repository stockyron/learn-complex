package com.rg.mybatis.springMybatis;

import com.rg.mybatis.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.mybatis.springMybatis 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月03日12:46   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class TestMain {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
        System.out.println(userMapper.getUser(7));
    }

}
