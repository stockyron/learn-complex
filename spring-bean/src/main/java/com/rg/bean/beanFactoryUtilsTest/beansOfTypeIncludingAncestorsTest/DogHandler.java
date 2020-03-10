package com.rg.bean.beanFactoryUtilsTest.beansOfTypeIncludingAncestorsTest;

import org.springframework.stereotype.Component;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.beanFactoryUtilsTest.beansOfTypeIncludingAncestorsTest 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月18日12:44   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Component
public class DogHandler implements IBeanConverter {

    private static final String TYPE = "dog";

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public boolean match(String type) {
        return getType().equals(type);
    }

    @Override
    public String getName() {
        return "this bean is " + this.getClass().getName();
    }
}
