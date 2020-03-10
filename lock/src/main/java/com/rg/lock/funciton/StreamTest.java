package com.rg.lock.funciton;

import java.util.ArrayList;
import java.util.List;
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
public class StreamTest {

    public static void main(String[] args) {
        List<People> list = new ArrayList<>();
        list.add(new People(1, "AA"));
        list.add(new People(3, "CC"));
        list.add(new People(2, "BB"));
        list.stream().parallel().forEach(e -> System.out.println(e));
        list.stream().parallel().forEachOrdered(e -> System.out.println(e));

        IntStream intStream = list.stream().mapToInt(People::getAge);
        int[] ints = intStream.toArray();
        for (int i : ints) {
            System.out.println(i);
        }

        List<String> list1 = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        System.out.println(list1);
    }

}
