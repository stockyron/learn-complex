package com.rg.lock.funciton;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock.funciton 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月15日16:54   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class CollectersTest {


    public static void main(String[] args) {
        Stream<Integer> s1 = Stream.of(1, 33, 23, 2);
        Integer collect = s1.collect(Collectors.summingInt(e -> e + 1));
        System.out.println(collect);

        List<People> list = new ArrayList<>();
        list.add(new People(11, "AA", 1000));
        list.add(new People(33, "CC", 12000));
        list.add(new People(22, "BB", 5000));
        list.add(new People(25, "DD", 5000));
        list.stream().collect(Collectors.summingInt(e -> e.getAge()));

        //按工资分组
        Map<Integer, List<People>> collect1 = list.stream().collect(Collectors.groupingBy(People::getSalary));
        System.out.println(collect1);

        //按工资分组统计人数
        Map<Integer, Long> collect2 = list.stream().collect(Collectors.groupingBy(People::getSalary, Collectors.counting()));
        System.out.println(collect2);

        //按工资分组统计分组总年龄
        Map<Integer, Integer> collect3 = list.stream().collect(Collectors.groupingBy(People::getSalary, Collectors.summingInt(e -> e.getAge())));
        System.out.println(collect3);

        //Supplier的上限是Map
        HashMap<Integer, Integer> collect4 = list.stream().collect(Collectors.groupingBy(People::getSalary, LinkedHashMap::new, Collectors.summingInt(e -> e.getAge())));
        System.out.println(collect4);
        TreeMap<Integer, Integer> collect5 = list.stream().collect(Collectors.groupingBy(People::getSalary, TreeMap::new, Collectors.summingInt(e -> e.getAge())));
        System.out.println(collect5);

    }


}
