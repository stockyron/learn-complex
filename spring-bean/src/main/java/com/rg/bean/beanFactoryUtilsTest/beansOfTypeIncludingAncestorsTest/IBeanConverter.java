package com.rg.bean.beanFactoryUtilsTest.beansOfTypeIncludingAncestorsTest;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.beanFactoryUtilsTest.beansOfTypeIncludingAncestorsTest 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月18日12:42   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public interface IBeanConverter {

    String getType();
    boolean match(String type);
    String getName();

}
