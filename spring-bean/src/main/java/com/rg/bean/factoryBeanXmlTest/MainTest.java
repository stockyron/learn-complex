package com.rg.bean.factoryBeanXmlTest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.xmlBeanFactoryTest 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月18日15:31   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class MainTest {

    //xml配置工厂模式
    public static void main(String[] args) {
        // 资源加载
        ClassPathResource classPathResource = new ClassPathResource("spring-bean.xml");
        // 1.XmlBeanFactory 加载资源并解析注册bean
        BeanFactory beanFactory = new XmlBeanFactory(classPathResource);
        // 2.BeanFactory.getBean();
        Animal animal = (Animal) beanFactory.getBean("cat");
        System.out.println(animal);
    }


}
