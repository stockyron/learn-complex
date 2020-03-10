package com.rg.aop.aspectj;

import lombok.Data;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.aop 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月31日18:14   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Data
public class TestBean {

    private String testStr = "testStr";

    public void test(){
        System.out.println("test");
    }

}
