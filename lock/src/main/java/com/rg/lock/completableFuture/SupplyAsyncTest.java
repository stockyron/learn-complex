package com.rg.lock.completableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

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
public class SupplyAsyncTest {

    public static void main(String[] args) throws Exception {
        List<Future> list = new ArrayList<>();

        /*ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            String s = "future 2 " + Thread.currentThread().getName() + " 是否是守护：" + Thread.currentThread().isDaemon();
            System.out.println(s);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future 2 end");
            return s;
        }, executor);
        executor.shutdown();
        list.add(future2);*/

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            String s = "future 1 " + Thread.currentThread().getName() + " 是否是守护：" + Thread.currentThread().isDaemon();
            System.out.println(s);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future 1 end");
            return s;
        });
        list.add(future1);

        /*for (Future future : list) {
            Object o = future.get();
            System.out.println(o);
        }*/

        //future 1 ForkJoinPool.commonPool-worker-9 是否是守护：true
        TimeUnit.SECONDS.sleep(2);
        //future1.get();//不用get方法阻塞主线程会导致任务执行中断  future 1 end不打印
    }

}
