package com.rg.lock.base;

import lombok.extern.slf4j.Slf4j;

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
 *  * @CreateDate:  2019年12月11日12:16   
 *  * @Version:   v1.0
 *  *    
 *  
 */
@Slf4j
public class ReentrantLockTest {


    private ArrayList<String> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        final ReentrantLockTest test = new ReentrantLockTest();

        new Thread(getRunnable(test), "1").start();
        new Thread(getRunnable(test), "2").start();
        new Thread(getRunnable(test), "3").start();
        new Thread(getRunnable(test), "4").start();
        new Thread(getRunnable(test), "5").start();
    }

    private static Runnable getRunnable(ReentrantLockTest test) {
        return () -> test.insert();
    }

    public void insert() {
        Lock lock = new ReentrantLock();    //注意这个地方
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到了锁:" + arrayList);
            for (int i = 0; i < 5; i++) {
                arrayList.add(Thread.currentThread().getName() + "-" + i);
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了锁:" + arrayList);
            lock.unlock();
        }
    }
    //5得到了锁:[]
    //4得到了锁:[]
    //1得到了锁:[]
    //4释放了锁:[5-0, 5-1, 5-2, 5-3, 5-4, 4-0, 4-1, 4-2, 4-3, 4-4]
    //3得到了锁:[]
    //2得到了锁:[]
    //3释放了锁:[5-0, 5-1, 5-2, 5-3, 5-4, 4-0, 4-1, 4-2, 4-3, 4-4, 1-0, 1-1, 1-2, 1-3, 1-4, 3-0, 3-1, 3-2, 3-3, 3-4]
    //1释放了锁:[5-0, 5-1, 5-2, 5-3, 5-4, 4-0, 4-1, 4-2, 4-3, 4-4, 1-0, 1-1, 1-2, 1-3, 1-4]
    //5释放了锁:[5-0, 5-1, 5-2, 5-3, 5-4]
    //2释放了锁:[5-0, 5-1, 5-2, 5-3, 5-4, 4-0, 4-1, 4-2, 4-3, 4-4, 1-0, 1-1, 1-2, 1-3, 1-4, 3-0, 3-1, 3-2, 3-3, 3-4, 2-0, 2-1, 2-2, 2-3, 2-4]
    //最终结果是数据都进来了，但是获取到锁的时候arrayList为啥为空？打印的方法里面有synchronized关键字
}
