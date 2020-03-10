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
public class HasQueueThreadTest {

    private ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        HasQueueThreadTest test = new HasQueueThreadTest();
        Thread threadA = new Thread(() -> test.waitMethod());
        threadA.start();
        Thread.sleep(500);
        Thread threadB = new Thread(() -> test.waitMethod());
        threadB.start();
        Thread.sleep(500);
        System.out.println(test.lock.hasQueuedThread(threadA));
        System.out.println(test.lock.hasQueuedThread(threadB));
        System.out.println(test.lock.hasQueuedThreads());
        //false
        //true
        //true
    }

    public void waitMethod(){
        try {
            lock.lock();
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


}
