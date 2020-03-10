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
public class QueueLenthTest {

    private ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        QueueLenthTest test = new QueueLenthTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> test.holdCount1(), i + "").start();
        }
        //
    }

    //查询正等待获取此锁定的预估线程数。
    public void holdCount1(){
        try {
            lock.lock();
            System.out.println("ThreadName = " + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("预估等待锁线程数：" + lock.getQueueLength());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


}
