package com.rg.bean.iteratorTest;

import java.util.HashMap;
import java.util.Map;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.iteratorTest 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月20日11:12   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class HashMapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");

        map.computeIfPresent("c", (k, v) -> k + v +1);
        System.out.println(map);

    }

}
