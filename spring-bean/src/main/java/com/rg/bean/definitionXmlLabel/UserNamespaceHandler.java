package com.rg.bean.definitionXmlLabel;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.definitionXmlLabel 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月23日17:56   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class UserNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }

}
