package com.rg.lock.base;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月11日12:21   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class TryLockTest {

    private ArrayList<Integer> arrayList = new ArrayList<>();

    private Lock lock = new ReentrantLock();//注意这个地方

    public static void main(String[] args) {
        final TryLockTest test = new TryLockTest();

        new Thread(getRunnable(test)).start();

        new Thread(getRunnable(test)).start();
    }

    private static Runnable getRunnable(TryLockTest test) {
        return () -> test.insert(Thread.currentThread());
    }

    public void insert(Thread thread) {
        if (lock.tryLock()) {
            try {
                System.out.println(thread.getName() + "得到了锁");
                for (int i = 0; i < 5; i++) {
                    arrayList.add(i);
                }
            } catch (Exception e) {
                // TODO: handle exception
            } finally {
                System.out.println(thread.getName() + "释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println(thread.getName() + "获取锁失败");
        }
    }

}
