package com.rg.lock.base;

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
public class HoldCountTest {

    private ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        HoldCountTest test = new HoldCountTest();
        test.holdCount1();
        //holdCount1 = 1
        //holdCount2 = 2
    }

    //查询当前线程保持此锁定的个数，即调用lock()方法的次数。
    public void holdCount1(){
        try {
            lock.lock();
            System.out.println("holdCount1 = " + lock.getHoldCount());
            holdCount2();
        } finally {
            lock.unlock();
        }

    }

    public void holdCount2(){
        try {
            lock.lock();
            System.out.println("holdCount2 = " + lock.getHoldCount());
        } finally {
            lock.unlock();
        }

    }

}
