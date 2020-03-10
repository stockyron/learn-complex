package com.rg.lock.timer;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock.timer 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月15日12:57   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class ScheduledThreadPoolExecutorTest {

    static ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);

    public static void main(String[] args) {
        scheduledThreadPoolExecutor.schedule(() ->{
                System.out.println("---one Task---");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                throw new RuntimeException("error ");
        }, 500, TimeUnit.MICROSECONDS);

        scheduledThreadPoolExecutor.schedule(() -> {
                for (int i =0;i<5;++i) {
                    System.out.println("---two Task---");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }, 500, TimeUnit.MICROSECONDS);

        scheduledThreadPoolExecutor.shutdown();

    }

}
