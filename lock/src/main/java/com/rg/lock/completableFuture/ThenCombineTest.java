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
public class ThenCombineTest {

    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("start "+ Thread.currentThread());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "finish";
        });
        TimeUnit.SECONDS.sleep(4);
        //不阻塞主线程,future1线程执行完了就用future1线程,2个方法似乎没区别
        CompletableFuture<String> combine = future1.thenCombineAsync(CompletableFuture.supplyAsync(() -> {
        //CompletableFuture<String> combine = future1.thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println("other：" + Thread.currentThread());
            return 2;
        }), (r1, r2) -> r1 + r2);
        System.out.println(combine.get());//finish2

    }

}
