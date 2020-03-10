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
 *  * @CreateDate:  2019年12月11日17:11   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class UnfairTest {

    private Lock lock;

    private boolean isFair;

    public UnfairTest(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public static void main(String[] args) {
        UnfairTest test = new UnfairTest(false);
        for (int i = 1; i <= 10; i++) {
            new Thread(getProductor(test), "A" + i).start();
        }

    }

    private static Runnable getProductor(UnfairTest test) {
        return () -> {
            test.set();
        };
    }

    public void set(){
        try {
            lock.lock();
            System.out.println("ThreadName=" + Thread.currentThread().getName() + "获得了锁");
        } finally {
            lock.unlock();
        }

    }





}
