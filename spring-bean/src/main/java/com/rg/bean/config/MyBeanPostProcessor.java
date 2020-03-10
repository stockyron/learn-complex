package com.rg.bean.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.config 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月17日10:26   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("MyBeanPostProcessor Before beanName = " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("MyBeanPostProcessor After beanName = " + beanName);
        return bean;
    }

    @PostConstruct
    public void init(){
        System.out.println("MyBeanPostProcessor init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("MyBeanPostProcessor destroy");
    }

}
