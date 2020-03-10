package com.rg.lock.funciton;

import java.util.ArrayList;
import java.util.function.Predicate;
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
public class CollectTest {


    public static void main(String[] args) {
        Stream<String> s1 = Stream.of("aa", "ab", "c", "ad");
        Predicate<String> predicate = t -> t.contains("a");
        System.out.println(s1.parallel().collect(() -> new ArrayList<String>(),
                (array, s) -> {if (predicate.test(s)) array.add(s); },
                (array1, array2) -> array1.addAll(array2)));

    }


}
