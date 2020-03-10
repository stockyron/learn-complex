package com.rg.lock.funciton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock.funciton 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月16日10:54   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class ConllectingAndThenTest {

    public static void main(String[] args) {
        List<People> list = new ArrayList<>();
        list.add(new People(11, "AA", 1000));
        list.add(new People(33, "CC", 12000));
        list.add(new People(25, "DD", 5000));
        list.add(new People(22, "BB", 5000));

        System.out.println(list.stream().collect(Collectors.groupingBy(People::getSalary,
                Collectors.collectingAndThen(Collectors.summingInt(People::getAge),
                        x -> x + "ok"))));
        //{12000=33ok, 5000=47ok, 1000=11ok}

    }

}
