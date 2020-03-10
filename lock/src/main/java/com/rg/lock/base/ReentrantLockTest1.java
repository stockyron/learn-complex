package com.rg.lock.base;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月11日12:16   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Slf4j
public class ReentrantLockTest1 {

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        final ReentrantLockTest1 test = new ReentrantLockTest1();

        new Thread(getA(test), "A").start();
        new Thread(getA(test), "AA").start();
        new Thread(getB(test), "B").start();
        new Thread(getB(test), "BB").start();

        //TimerTest begin ThreadName=A time=1576049682138
        //TimerTest end ThreadName=A time=1576049682138
        //TimerTest begin ThreadName=AA time=1576049687138
        //TimerTest end ThreadName=AA time=1576049687138
        //b begin ThreadName=B time=1576049692139
        //b end ThreadName=B time=1576049692139
        //b begin ThreadName=BB time=1576049697140
        //b end ThreadName=BB time=1576049697140
        //对象监听器，跟synchronized一样顺序执行
    }

    private static Runnable getA(ReentrantLockTest1 test) {
        return () -> test.a();
    }
    private static Runnable getB(ReentrantLockTest1 test) {
        return () -> test.b();
    }

    public void a() {
        try {
            lock.lock();
            String name = Thread.currentThread().getName();
            long timestamp = System.currentTimeMillis();
            System.out.println("TimerTest begin ThreadName=" + name + " time=" + timestamp);
            Thread.sleep(5000);
            System.out.println("TimerTest end ThreadName=" + name + " time=" + timestamp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void b() {
        try {
            lock.lock();
            String name = Thread.currentThread().getName();
            long timestamp = System.currentTimeMillis();
            System.out.println("b begin ThreadName=" + name + " time=" + timestamp);
            Thread.sleep(5000);
            System.out.println("b end ThreadName=" + name + " time=" + timestamp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
