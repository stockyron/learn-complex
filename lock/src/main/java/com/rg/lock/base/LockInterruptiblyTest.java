package com.rg.lock.base;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月11日12:23   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class LockInterruptiblyTest {

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockInterruptiblyTest test = new LockInterruptiblyTest();
        Thread thread1 = new Thread(getRunnable(test), "1");
        Thread thread2 = new Thread(getRunnable(test), "2");
        thread1.start();
        thread2.start();

        try {
            System.out.println(Thread.currentThread().getName() + "继续执行");
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();//要执行到此位置2才会被中断
    }

    private static Runnable getRunnable(LockInterruptiblyTest test) {
        return () -> {
            try {
                test.insert(Thread.currentThread());
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被中断");
            }
        };
    }

    public void insert(Thread thread) throws InterruptedException {
        //注意，如果需要正确中断等待锁的线程，必须将获取锁放在外面，然后将InterruptedException抛出
        lock.lockInterruptibly();
        try {
            System.out.println(thread.getName() + "得到了锁");
            long startTime = System.currentTimeMillis();
            while (true) {
                if (System.currentTimeMillis() - startTime >= 5000){
                    System.out.println(thread.getName() + "插入数据");
                    break;
                }
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + "执行finally");
            lock.unlock();
            System.out.println(thread.getName() + "释放了锁");
        }
    }


}
