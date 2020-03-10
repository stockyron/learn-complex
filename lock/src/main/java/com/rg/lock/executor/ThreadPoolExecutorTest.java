package com.rg.lock.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock.executor 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月15日10:13   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class ThreadPoolExecutorTest {


    //我们创建了一个核心线程为：2，最大线程数为：4，空闲线程存活的时间为：10秒，有界队列的容量为：3的线程池。
    // 然后我们模拟提交10个任务，为了让id小的任务先有机会运行，我们提交一个任务后先休眠30ms，然后模拟每个任务需要执行1秒，确认10个任务都是先提交了，才有任务执行完
    public static void main(String[] args) throws Exception {
        ExecutorService executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));
        for (int i = 1; i <= 10; ++i) {
            final int index = i;
            Runnable runnable = () -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "我是任务" + index);
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
            executor.submit(runnable);
            //这里确认id小的任务先提交到线程池
            TimeUnit.MILLISECONDS.sleep(30);
        }
        executor.shutdown();
    }
    //pool-1-thread-1我是任务1
    //pool-1-thread-2我是任务2
    //pool-1-thread-3我是任务6
    //pool-1-thread-4我是任务7
    //Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTask@3f91beef rejected from java.util.concurrent.ThreadPoolExecutor@1a6c5a9e[Running, pool size = 4, active threads = 4, queued tasks = 3, completed tasks = 0]
    //	at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2063)
    //	at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:830)
    //	at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1379)
    //	at java.util.concurrent.AbstractExecutorService.submit(AbstractExecutorService.java:112)
    //	at com.rg.lock.executor.ThreadPoolExecutorTest.main(ThreadPoolExecutorTest.java:37)
    //pool-1-thread-1我是任务3
    //pool-1-thread-2我是任务4
    //pool-1-thread-3我是任务5
    //先用核心线程（2个）先执行，后来进来的任务先放入队列（3），队列满了再创建2个新的线程直到达到最大线程数，后来进来的任务如果
    //没有空闲线程就直接用拒绝策略


}
