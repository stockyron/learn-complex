package com.rg.bean.xmlBeanFactoryTest;

import lombok.Data;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.xmlBeanFactoryTest 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月18日15:30   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Data
public class User {

    String name;

    public User(String name) {
        this.name = name;
    }




}
