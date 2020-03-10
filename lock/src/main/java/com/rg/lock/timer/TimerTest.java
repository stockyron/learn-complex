package com.rg.lock.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *    
 *  *  
 *  * @Project: learn-complex 
 *  * @Package: com.rg.lock.timer 
 *  * @Description: TODO   
 *  * @Author:   horus   
 *  * @CreateDate:  2019年12月15日12:21   
 *  * @Version:   v1.0
 *  *    
 *  
 */
public class TimerTest {

    //一个timer只有一个timeThread执行，所有要放置多个任务就必须要注意
    // run方法里面异常的捕获和时间合理性
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(("timer task test"));
            }
        };
        new Timer().schedule(task, new Date(), 1000);

    }

}
