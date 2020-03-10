package com.rg.lock.ResolvableType;

import org.springframework.core.ResolvableType;

import java.util.ArrayList;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock.ResolvableType 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月17日18:55   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class ForClassTest {

    public static void main(String[] args) {
        ResolvableType type = ResolvableType.forClass(ExtendsList.class);
        System.out.println(type.getType());
    }

    static class ExtendsList extends ArrayList<CharSequence>{

    }

}
