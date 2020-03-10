package com.rg.lock.funciton;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock.funciton 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月15日18:41   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class ReduceTest {

    public static void main(String[] args) {
        Stream<Integer> s0 = Stream.of(1, 2, 3, 4, 5, 6);

        Integer sum1 = s0.reduce((m, n) -> m + n).get();
        System.out.println(sum1);
        //初始化值
        Stream<Integer> s = Stream.of(1, 2, 3, 4, 5, 6);
        Integer sum2 = s.reduce(0, (m, n) -> m + n);
        System.out.println(sum2);

        //串行流第3个参数无效
        Stream<String> s1 = Stream.of("aa", "ab", "c", "ad");
        ArrayList<String> reduce = s1.reduce(new ArrayList<>(),
                (m, n) -> {
                    m.add(n);
                    return m;
                }, (x, y) -> x);
        System.out.println(reduce);

        //每次拿0+1 0+2 0+3 后再汇总 1*2*3
        Stream<Integer> s2 = Stream.of(1, 2, 3);
        Integer sum = s2.parallel().reduce(0, (x, y) -> x + y, (x, y) -> x * y);
        System.out.println(sum);

        Stream<String> s3 = Stream.of("aa", "ab", "c", "ad");

//模拟Filter查找其中含有字母a的所有元素，由于使用了r1.addAll(r2)，其打印结果将不会是预期的aa ab ad
        Predicate<String> predicate = t -> t.contains("a");
        s3.parallel().reduce(new ArrayList<String>(), (r, t) -> {
                    if (predicate.test(t)) r.add(t);
                    return r;
                },
                (r1, r2) -> { //每次处理都是拿的第一次创建的ArrayList  注意！！！
//                    System.out.println(r1 == r2);//true
//                    r1.addAll(r2);
                    return r1;
                }).stream().forEach(System.out::println);

    }
}
