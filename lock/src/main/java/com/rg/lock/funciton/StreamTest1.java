package com.rg.lock.funciton;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock.funciton 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月15日17:10   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class StreamTest1 {

    public static void main(String[] args) {
        List<People> list = new ArrayList<>();
        list.add(new People(3, "CC"));
        list.add(new People(1, "AA"));
        list.add(new People(2, "BB"));
        list.add(new People(4, "EE"));
        list.add(new People(4, "DD"));

        //好东西
        /*People[] a = list.stream().toArray(e -> new People[e]);
        for (People people : a) {
            System.out.println(people);
        }*/
        People people = list.stream().reduce(new People(7, "ZZ"),
                BinaryOperator.maxBy(Comparator.comparing(People::getAge)));
        System.out.println(people);

        Optional<People> optional= list.stream().reduce(
                BinaryOperator.minBy(Comparator.comparing(People::getAge, Comparator.reverseOrder())));
        System.out.println(optional.get());

    }

}
