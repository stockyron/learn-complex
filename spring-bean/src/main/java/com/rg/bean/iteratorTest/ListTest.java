package com.rg.bean.iteratorTest;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.bean.iteratorTest 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月20日14:50   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class ListTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            list.add(i + 1);
        }

        list.removeAll(Arrays.asList(1,2,3));

        /*Integer [] a = new Integer[4];
        System.out.println(Arrays.asList(list.toArray()));
        System.out.println(Arrays.asList(list.toArray(a)));
        System.out.println(Arrays.asList(a));*/

        /*new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Exception in thread "main" java.util.ConcurrentModificationException
            list.add(200);
        }).start();*/

        /*ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/

        /*Spliterator<Integer> s1 = list.spliterator();
        Spliterator<Integer> s3 = s1.trySplit();
        Spliterator<Integer> s2 = s1.trySplit();
        Spliterator<Integer> s4 = s3.trySplit();

        s1.forEachRemaining(e -> System.out.println("s1:" + e));
        s2.forEachRemaining(e -> System.out.println("s2:" + e));
        s3.forEachRemaining(e -> System.out.println("s3:" + e));
        s4.forEachRemaining(e -> System.out.println("s4:" + e));*/
    }

}
