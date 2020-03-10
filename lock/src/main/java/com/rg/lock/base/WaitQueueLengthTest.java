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
public class WaitQueueLengthTest {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) {
        WaitQueueLengthTest test = new WaitQueueLengthTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> test.waitMethod()).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.notifyMethed();
    }

    public void waitMethod(){
        try {
            lock.lock();
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void notifyMethed(){
        try {
            lock.lock();
            System.out.println("等待线程 " + lock.getWaitQueueLength(condition));
            condition.signal();
        } finally {
            lock.unlock();
        }

    }

}
