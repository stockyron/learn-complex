package com.rg.lock.base;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月12日9:19   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class ReadWriteLockTest {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ReadWriteLockTest test = new ReadWriteLockTest();
        new Thread(() -> test.readLock(), "A").start();
        //new Thread(() -> test.readLock(), "B").start();

        new Thread(() -> test.writeLock(), "C").start();
        //new Thread(() -> test.writeLock(), "D").start();

        //读写 写读 写写都是互斥的
    }

    public void readLock() {
        try {
            lock.readLock().lock();
            System.out.println("获得读锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }

    }

    public void writeLock() {
        try {
            lock.writeLock().lock();
            System.out.println("获得写锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }

    }



}
