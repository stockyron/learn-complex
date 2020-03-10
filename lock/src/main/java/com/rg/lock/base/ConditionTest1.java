package com.rg.lock.base;

import java.util.concurrent.locks.Condition;
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
public class ConditionTest1 {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) {
        ConditionTest1 test = new ConditionTest1();
        new Thread(() -> test.awaitA(), "A").start();
        new Thread(() -> test.awaitB(), "B").start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.signalAll();
    }

    public void awaitA(){
        try {
            lock.lock();
            String name = Thread.currentThread().getName();
            System.out.println("awaitA begin wait的时间 + " + System.currentTimeMillis()
                    + " ThreadName=" + name);
            condition.await();
            System.out.println("awaitA end wait的时间 + " + System.currentTimeMillis()
                    + " ThreadName=" + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitB(){
        try {
            lock.lock();
            String name = Thread.currentThread().getName();
            System.out.println("awaitB begin wait的时间 + " + System.currentTimeMillis()
                    + " ThreadName=" + name);
            condition.await();
            System.out.println("awaitB end wait的时间 + " + System.currentTimeMillis()
                    + " ThreadName=" + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll(){
        try {
            lock.lock();
            System.out.println("signalAll 时间为" + System.currentTimeMillis());
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }



}
