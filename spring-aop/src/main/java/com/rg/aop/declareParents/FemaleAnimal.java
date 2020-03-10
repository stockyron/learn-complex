package com.rg.aop.declareParents;

import org.springframework.stereotype.Component;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.aop.declareParents 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2020年01月01日17:05   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Component
public class FemaleAnimal implements Animal {

    @Override
    public void eat() {
        System.out.println("我是雌性，我比雄性更喜欢吃零食");
    }

}
