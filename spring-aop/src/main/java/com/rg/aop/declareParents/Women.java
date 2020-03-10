package com.rg.aop.declareParents;

import org.springframework.stereotype.Component;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.aop.declareParents 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月01日17:04   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Component
public class Women implements Person{

    @Override
    public void likePerson() {
        System.out.println("我是女生，我喜欢帅哥");
    }

}
