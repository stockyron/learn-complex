package com.rg.lock.completableFuture;

import java.util.concurrent.CompletableFuture;
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
public class ThenComposeTest {

    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("end "+ Thread.currentThread());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "finish";
        });
        //TimeUnit.SECONDS.sleep(4);
        //不阻塞主线程,不使用future1的线程执行
        //future1.thenComposeAsync()r ->  CompletableFuture.supplyAsync(() -> {
        //使用future1的线程执行
        future1.thenCompose(r ->  CompletableFuture.supplyAsync(() -> {
            System.out.println("上一个任务的返回结果：" + r + " " + Thread.currentThread());
            return 2;
        }));

        System.out.println("test");
        TimeUnit.SECONDS.sleep(5);
    }

}
