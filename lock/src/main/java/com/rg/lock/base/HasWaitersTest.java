package com.rg.lock.base;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

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
public class HasWaitersTest {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        HasWaitersTest test = new HasWaitersTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> test.waitMethod()).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.notifyMethod();
        //有没有线程正在等待condition？true 线程数是多少？10
    }

    public void waitMethod() {
        try {
            lock.lock();
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void notifyMethod() {
        try {
            lock.lock();
            System.out.println("有没有线程正在等待condition？" + lock.hasWaiters(condition)
                    + " 线程数是多少？" + lock.getWaitQueueLength(condition));
        } finally {
            lock.unlock();
        }
    }


}
