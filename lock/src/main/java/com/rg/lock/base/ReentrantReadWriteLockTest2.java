package com.rg.lock.base;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *   说明thread1和thread2在同时进行读操作。
 * 　　这样就大大提升了读操作的效率。
 * 　　不过要注意的是，如果有一个线程已经占用了读锁，则此时其他线程如果要申请写锁，则申请写锁的线程会一直等待释放读锁。
 * 　　如果有一个线程已经占用了写锁，则此时其他线程如果申请写锁或者读锁，则申请的线程会一直等待释放写锁。
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
public class ReentrantReadWriteLockTest2 {

    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    int i;

    public static void main(String[] args)  {
        final ReentrantReadWriteLockTest2 test = new ReentrantReadWriteLockTest2();

        new Thread(getRunnable(test), "1").start();
        new Thread(getRunnable(test), "2").start();

    }

    private static Runnable getRunnable(ReentrantReadWriteLockTest2 test){
        return () -> test.get();
    }

    public void get() {
        rwl.readLock().lock();
        try {
            long start = System.currentTimeMillis();

            while(System.currentTimeMillis() - start <= 1) {
                System.out.println(Thread.currentThread().getName()+"正在进行读操作" + i++);
            }
            System.out.println(Thread.currentThread().getName()+"读操作完毕");
        } finally {
            rwl.readLock().unlock();
        }
    }

}
