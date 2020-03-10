package com.rg.lock.base;

import javax.sql.DataSource;
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
public class AwaitUninterruptibleTest {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) {
        AwaitUninterruptibleTest test = new AwaitUninterruptibleTest();
        Thread thread = new Thread(() -> test.testMethod());
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    public void testMethod() {
        try {
            lock.lock();
            System.out.println("wait begin");
            condition.awaitUninterruptibly();//不能被中断
            System.out.println("wait end");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch");
        } finally {
            lock.unlock();
        }

    }


}
