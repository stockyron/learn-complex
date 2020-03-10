package com.rg.bean.iteratorTest;

import java.util.*;

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
public class TreeMapTest {

    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("a", 1);
        map.put("c", 3);
        map.put("b", 2);
        map.put("ba", 4);
        map.put("ca", 5);
        map.put("aa", 6);
        //map.put("aaa", 7);
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.putAll(map);//数据进去排序就好了？？？？？？
        System.out.println(treeMap);
        treeMap.put("aaa", 7);
    }

}
