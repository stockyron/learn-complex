package com.rg.bean.factoryBeanClass;

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
public class FactoryBeanMain {

    public static void main(String[] args) {
        // 资源加载
        ClassPathResource classPathResource = new ClassPathResource("spring-bean.xml");
        // 1.XmlBeanFactory 加载资源并解析注册bean
        BeanFactory beanFactory = new XmlBeanFactory(classPathResource);
        // 2.BeanFactory.getBean();
        Car Car = (Car) beanFactory.getBean("car");
        System.out.println(Car);//Car(maxSpeed=400, brand=超级跑车, price=2000000.0)

        System.out.println(beanFactory.getBean("&&&car"));
        //com.rg.bean.factoryBeanClass.CarFacrotyBean@31dc339b
    }



}
