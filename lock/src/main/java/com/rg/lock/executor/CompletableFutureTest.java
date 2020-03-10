package com.rg.lock.executor;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock.executor 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月15日13:29   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws Exception {
        //返回一个指定结果的CompletableFuture对象
        //1. 提交一个一部执行的任务,无结果返回值
        CompletableFuture<Void> future = CompletableFuture.runAsync(() ->
                System.out.println("I have done Nothing")
        );
        //在springboot的异步方法中包装
        CompletableFuture<String> future1 = CompletableFuture.completedFuture("future 1");
        System.out.println(future1.get());

        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture.runAsync(() -> {
            System.out.println("Me, too");
        }, executor);
        executor.shutdown();

        //System.out.println(future.get());
        //2. 提交一个一部执行的任务,有结果返回值
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future 2");
            return "future2 finished!";
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future 3");
            return "future3 finished!";
        });

        CompletableFuture.allOf(future2, future3);
        System.out.println("future2: " + future2.isDone() + " future3: " + future3.isDone());

        int total = 0;
        for (int j = 0; j < 10; j++) {
            int i = j;
            CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> {
                System.out.println("future 4" + i);
                return i;
            });
            total += future4.get();
        }
        System.out.println(total);

        long l0 = System.nanoTime();
        total = 0;
        for (int j = 0; j < 10; j++) {
            int i = j;
            CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> {
                System.out.println("future 40" + i);
                try {
                    TimeUnit.SECONDS.sleep(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return i;
            });
            total += future4.get();
        }
        long l1 = System.nanoTime();
        System.out.println(total + " " + (l1 - l0));

        total = 0;
        for (int j = 0; j < 10; j++) {
            int i = j;
            total += CompletableFuture.supplyAsync(() -> {
                System.out.println("future 41" + i);
                try {
                    TimeUnit.SECONDS.sleep(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return i;
            }).thenApply(value -> {
                System.out.println("thenApply: " + value);
                return value;
            }).join();
        }
        long l2 = System.nanoTime();
        System.out.println(total + " " + (l2 - l1));

        total = 0;
        for (int j = 0; j < 10; j++) {
            total += j;
            TimeUnit.SECONDS.sleep(j);
        }
        long l3 = System.nanoTime();
        System.out.println(total + " " + (l3 - l2));

    }

    //有问题，会报错
    public static <T> CompletableFuture<List<T>> allOf(List<CompletableFuture<T>> futuresList) {
        CompletableFuture<T>[] arr = new CompletableFuture[futuresList.size()];
        for (int i = 0; i < futuresList.size(); i++) {
            arr[0] = futuresList.get(i);
        }

        CompletableFuture<Void> allFuturesResult = CompletableFuture.allOf(arr);
        return allFuturesResult
                .thenApply(v -> futuresList.stream().
                        map(future -> future.join()).
                        collect(Collectors.toList())
                );
    }

}
