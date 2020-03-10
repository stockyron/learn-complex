package com.rg.lock.executor;

import java.util.concurrent.*;

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
public class CompletableFutureTest1 {

    //两者均需要join()或者get()方法配合使用才能达到同步入参的返回值执行后面的操作,否则将异步执行;
    public static void main(String[] args) throws Exception {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "future 1");
        CompletableFuture<String> future2 = CompletableFuture.completedFuture("future 2");

        //没有join()配合使用,allOf后面的结果集若没有执行完毕则直接执行
        CompletableFuture.allOf(future1, future2)
                .thenAccept((value) -> System.out.println("success1 :" + value));

        CompletableFuture.allOf(future1, future2)
                .thenAccept((value) -> System.out.println("success2 :" + value))
                .join();

        CompletableFuture.allOf(future1, future2)
                .thenAccept((value) -> System.out.println("success3 :" + value))
                .get();

        CompletableFuture.allOf(future1, future2)
                .thenAccept((value) -> System.out.println("success4 :" + value))
                .get(2L, TimeUnit.SECONDS);
    }

}
