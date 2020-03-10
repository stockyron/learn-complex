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
public class WhenCompleteAsyncTest {

    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            String s = "this is first task " + Thread.currentThread() ;
            System.out.println(s);
            int i = 1/0;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end");
            return "finish";
        });
        TimeUnit.SECONDS.sleep(4);
        //不阻塞主线程
        future1.whenCompleteAsync((r, e) -> {//result  exception
            System.out.println("whenComplete " + Thread.currentThread()
                    + " 是否是守护：" + Thread.currentThread().isDaemon());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("正确输入结果" + r);
            System.out.println(e);
        });

        System.out.println("test");
        TimeUnit.SECONDS.sleep(2);
    }

}
