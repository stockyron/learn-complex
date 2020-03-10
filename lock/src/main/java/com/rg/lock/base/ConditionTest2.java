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
public class ConditionTest2 {

    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    public static void main(String[] args) {
        ConditionTest2 test = new ConditionTest2();
        new Thread(() -> test.awaitA(), "A").start();
        new Thread(() -> test.awaitB(), "B").start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.signalAll_A();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.signalAll_B();
    }

    public void awaitA(){
        try {
            lock.lock();
            String name = Thread.currentThread().getName();
            System.out.println("awaitA begin的时间 + " + System.currentTimeMillis()
                    + " ThreadName=" + name);
            conditionA.await();
            System.out.println("awaitA end的时间 + " + System.currentTimeMillis()
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
            System.out.println("awaitB begin的时间 + " + System.currentTimeMillis()
                    + " ThreadName=" + name);
            conditionB.await();
            System.out.println("awaitB end的时间 + " + System.currentTimeMillis()
                    + " ThreadName=" + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_A(){
        try {
            lock.lock();
            System.out.println("signalAll_A 时间为" + System.currentTimeMillis());
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_B(){
        try {
            lock.lock();
            System.out.println("signalAll_B 时间为" + System.currentTimeMillis());
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }
    }



}
