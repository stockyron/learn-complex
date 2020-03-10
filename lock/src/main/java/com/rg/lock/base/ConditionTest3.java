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
public class ConditionTest3 {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;

    public static void main(String[] args) {
        ConditionTest3 test = new ConditionTest3();
        new Thread(getProductor(test), "A").start();
        new Thread(getCustomer(test), "B").start();

    }

    private static Runnable getCustomer(ConditionTest3 test) {
        return () -> {
            for (int i = 0; i < 100; i++) {
                test.get();
            }
        };
    }

    private static Runnable getProductor(ConditionTest3 test) {
        return () -> {
            for (int i = 0; i < 100; i++) {
                test.set();
            }
        };
    }

    public void set(){
        try {
            lock.lock();
            while (hasValue){
                condition.await();
            }
            System.out.println("set***");
            hasValue = true;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get(){
        try {
            lock.lock();
            if(!hasValue){
                condition.await();
            }
            System.out.println("get***");
            hasValue = false;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }




}
