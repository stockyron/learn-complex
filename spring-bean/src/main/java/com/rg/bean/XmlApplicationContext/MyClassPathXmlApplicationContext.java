package com.rg.bean.XmlApplicationContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.XmlApplicationContext 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月25日10:13   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

    public MyClassPathXmlApplicationContext(String... configLocations) throws BeansException {
        super(configLocations);
    }

    @Override
    protected void initPropertySources() {
        //添加验证要求
        getEnvironment().setRequiredProperties("VAR");
    }

    //设置 是否允许同名称覆盖 循环依赖允许
    @Override
    protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
        beanFactory.setAllowBeanDefinitionOverriding(true);
        beanFactory.setAllowCircularReferences(false);
        //设置 @Autowire和 @Qualifier注解解析器
        //beanFactory.setAutowireCandidateResolver();
        super.customizeBeanFactory(beanFactory);
    }

    public static void main(String[] args) {
        ApplicationContext ac = new MyClassPathXmlApplicationContext("spring-bean.xml");
        System.out.println(ac.getBean("car"));
        //Exception in thread "main" org.springframework.core.env.MissingRequiredPropertiesException: The following properties were declared as required but could not be resolved: [VAR]
    }
}
