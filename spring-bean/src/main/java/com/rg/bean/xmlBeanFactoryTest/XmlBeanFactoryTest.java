package com.rg.bean.xmlBeanFactoryTest;

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
public class XmlBeanFactoryTest {

    //https://blog.csdn.net/qq_30257149/article/details/87972291
    public static void main(String[] args) {
        // 资源加载
        ClassPathResource classPathResource = new ClassPathResource("spring-bean.xml");
        // 1.XmlBeanFactory 加载资源并解析注册bean
        BeanFactory beanFactory = new XmlBeanFactory(classPathResource);
        // 2.BeanFactory.getBean();
        User userBean = (User) beanFactory.getBean("userBean");
        System.out.println(userBean);
    }

    // XmlBeanDefinitionReader
    //public int registerBeanDefinitions(Document doc, Resource resource) throws BeanDefinitionStoreException {
    //        BeanDefinitionDocumentReader documentReader = this.createBeanDefinitionDocumentReader();
    //        int countBefore = this.getRegistry().getBeanDefinitionCount();
    //        documentReader.registerBeanDefinitions(doc, this.createReaderContext(resource));
    //        return this.getRegistry().getBeanDefinitionCount() - countBefore;
    //}
    //在registerBeanDefinitions方法具体实现：
    //
    //1：通过BeanUtils.instantiateClass(this.documentReaderClass)的方法实例化BeanDefinitionDocumentReader；
    //
    //2：通过DefaultListAbleBeanFactory中的beanDefinitionMap.size()获取之前注册bean的个数，（beanDefinitionMap是存储最终的xml解析后信息的载体，xml解析后信息是由GenericBeanDefinition进行存储，beanDefinitionMap的存储格式是key:String  value:GenericBeanDefinition）
    //
    //3:将解析xml和注册的工作委托给BeanDefinitionDocumentReader的registerBeanDefinitions方法；
    //
    //4：记录本次加载个数并返回；


}
