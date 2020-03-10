package com.rg.bean.factoryBeanXmlTest;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.factoryBeanXmlTest 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月19日12:58   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class InitFactory {

    //bean  factory-bean factory-method......

    public Animal get(){
        System.out.println("get ...");
        return new Cat();
    }
}
