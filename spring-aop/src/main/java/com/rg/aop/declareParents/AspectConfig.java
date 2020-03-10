package com.rg.aop.declareParents;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.aop.declareParents 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月01日17:06   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Aspect
@Component
public class AspectConfig {

    //"+"表示person的所有子类；defaultImpl 表示默认需要添加的新的类
    @DeclareParents(value = "com.rg.aop.declareParents.Person+", defaultImpl = FemaleAnimal.class)
    public Animal animal;

}
