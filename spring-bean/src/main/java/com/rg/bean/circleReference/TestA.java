package com.rg.bean.circleReference;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.circleReference 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月24日14:43   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Data
@AllArgsConstructor
public class TestA {

    private TestB testB;

    public void a(){
        testB.b();
    }

}
