package com.rg.lock.base;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月11日13:44   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class ReentrantReadWriteLockTest {

    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    int i;

    public static void main(String[] args)  {
        final ReentrantReadWriteLockTest test = new ReentrantReadWriteLockTest();

        new Thread(getRunnable(test), "1").start();
        new Thread(getRunnable(test), "2").start();
    }

    private static Runnable getRunnable(ReentrantReadWriteLockTest test){
        return () -> test.get();
    }

    public synchronized void get() {
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis() - start <= 1) {
            System.out.println(Thread.currentThread().getName()+"正在进行读操作" + i++);
        }
        System.out.println(Thread.currentThread().getName()+"读操作完毕");
    }

}
