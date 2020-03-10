package com.rg.lock.funciton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock.funciton 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月15日15:30   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class FunctionTest {

    public static void main(String[] args) {
        Function<Integer, Double> function = x -> {
            System.out.println("function执行");
            return x + 1.0;
        };

        Function<Character, Integer> before = x -> {
            System.out.println(x instanceof Character);
            System.out.println(x + 2);
            return x + 2;
        };
        System.out.println(function.compose(before).apply('x'));

        Function<Double, String> after = x -> x + "ok";
        System.out.println(function.andThen(after).apply(1));

        System.out.println(function.apply(1));

        Function<Object, Object> identity = Function.identity();
        System.out.println(identity.apply("ok"));


        Map<String, String> map = Arrays.asList("a", "b", "c")
                .stream()
//                .iteratorTest(Function.identity()) // <- This,
//                .iteratorTest(str -> str)          // <- is the same as this.
                .collect(Collectors.toMap(
                        k -> k, // <-- And this,
                        Function.identity()));
        System.out.println(map);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int[] arrayOK = list.stream().mapToInt(i -> i).toArray();
        for (int i : arrayOK) {
            System.out.println(i);
        }
    }

}
