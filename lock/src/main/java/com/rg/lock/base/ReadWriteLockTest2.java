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
public class ReadWriteLockTest2 {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock lock1 = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ReadWriteLockTest2 test = new ReadWriteLockTest2();
        new Thread(() -> test.readLock(), "A").start();
        new Thread(() -> test.readLock(), "B").start();

        new Thread(() -> test.writeLock(), "C").start();
        new Thread(() -> test.writeLock(), "D").start();
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
            lock1.writeLock().lock();
            System.out.println("获得写锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock1.writeLock().unlock();
        }

    }



}
