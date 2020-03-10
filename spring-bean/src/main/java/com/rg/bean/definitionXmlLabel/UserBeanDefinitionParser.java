package com.rg.bean.definitionXmlLabel;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.definitionXmlLabel 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月23日17:50   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class UserBeanDefinitionParser extends AbstractSimpleBeanDefinitionParser {

    //Element对应的类
    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    //从element中解析并提取对应的元素
    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        String username = element.getAttribute("username");
        String email = element.getAttribute("email");
        String id = element.getAttribute("id");

        if(StringUtils.hasText(username)){
            builder.addPropertyValue("username", username);
        }
        if(StringUtils.hasText(email)){
            builder.addPropertyValue("email", email);
        }
        if(StringUtils.hasText(username)){
            builder.addPropertyValue("id", id);
        }

    }
}
