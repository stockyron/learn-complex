package com.rg.lock.base;

import java.util.*;
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
public class ConditionTest4 {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        ConditionTest4 test = new ConditionTest4();
        /*new Thread(getProductor(test), "A").start();
        new Thread(getCustomer(test), "B").start();*/
        for (int i = 1; i <= 5; i++) {
            new Thread(getProductor(test), "A" + i).start();
            new Thread(getCustomer(test), "B" + i).start();
        }

    }

    private static Runnable getCustomer(ConditionTest4 test) {
        return () -> {
            for (int i = 0; i < 10; i++) {
                test.get(i + 1);
            }
        };
    }

    private static Runnable getProductor(ConditionTest4 test) {
        return () -> {
            for (int i = 0; i < 10; i++) {
                test.set(i + 1);
            }
        };
    }

    public void set(int i){
        try {
            lock.lock();
            String name = Thread.currentThread().getName();
            while (!list.isEmpty()){
                System.out.println(name + "第" + i + "次 s等待");
                condition.await();
            }
            list.add(UUID.randomUUID().toString());
            System.out.println(name + "第" + i +"次 s size=" + list.size());
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get(int i){
        try {
            lock.lock();
            String name = Thread.currentThread().getName();
            if(list.isEmpty()){
                System.out.println(name + "第" + i +"次 g等待 ");
                condition.await();
            }
            System.out.print(name + "第" + i +"次 g " + list.get(0));
            list.remove(0);
            System.out.println(" 还剩 " + list.size());
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }




}
