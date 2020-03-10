package com.rg.lock.funciton;

import java.util.HashMap;
import java.util.Map;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock.funciton 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月16日10:39   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class MapMergeTest {

    public static void main(String[] args) {
        People aa = new People(11, "AA", 1000);
        People cc = new People(33, "CC", 12000);
        People bb = new People(22, "BB", 5000);
        Map<Integer, People> map1 = new HashMap<>();
        map1.put(aa.getSalary(), aa);
        map1.put(bb.getSalary(), bb);
        map1.put(cc.getSalary(), cc);

        People dd = new People(25, "DD", 5000);
        /*Map<Integer, People> map2 = new HashMap<>();
        map2.put(dd.getSalary(), dd);*/

        map1.merge(dd.getSalary(), dd, (x,y) -> y );
        System.out.println(map1);

    }

}
