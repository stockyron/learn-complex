package com.rg.lock.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock.completableFuture 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月16日11:55   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class RunAsyncTest {

    public static void main(String[] args) {
        CompletableFuture.runAsync(() -> {
            String s = "future 1 " + Thread.currentThread().getName() + " 是否是守护：" + Thread.currentThread().isDaemon();
            System.out.println(s);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future 1 end");
        });

        System.out.println("a");

        /*ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture.runAsync(() -> {
            String s = "future 2 " + Thread.currentThread().getName() + " 是否是守护：" + Thread.currentThread().isDaemon();
            System.out.println(s);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future 1 end");
        }, executor);
        executor.shutdown();*/

        //future 1 ForkJoinPool.commonPool-worker-9 是否是守护：true
        //future 2 pool-1-thread-1 是否是守护：false
        //future 1 end
        //future 1 end
    }

}
