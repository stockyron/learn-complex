package com.rg.bean.iteratorTest;

import java.util.Arrays;
import java.util.List;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.iteratorTest 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月20日20:16   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class ArrayTest {

    public static void main(String[] args) {

        String [] a = {"a", "b", "c"};

        String [] r = a;
        r[0] = null;
        System.out.println(a == r);
        System.out.println(Arrays.asList(a));
        System.out.println(Arrays.asList(r));

    }

}
