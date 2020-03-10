package com.rg.bean.defaultListableBeanFactoryTest;

import com.rg.bean.config.MyBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月17日11:03   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class Test1 {

    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

//        MyBeanPostProcessor bean = factory.getBean(MyBeanPostProcessor.class);
//        System.out.println(bean.toString());
        //Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException:
        // No qualifying bean of type 'com.rg.bean.config.MyBeanPostProcessor' available

        AbstractBeanDefinition beanDefinition = new RootBeanDefinition(MyBeanPostProcessor.class);
        factory.registerBeanDefinition("myBean",beanDefinition);
        Object bean = factory.getBean("myBean");
        System.out.println(bean.toString());

        //可以通过构造方法注入依赖,当然我们这里没有
        //beanDefinition.setConstructorArgumentValues();

        //可以通过 setter 方法注入依赖,当然我们这里也没有
        //beanDefinition.setPropertyValues();
    }

}
