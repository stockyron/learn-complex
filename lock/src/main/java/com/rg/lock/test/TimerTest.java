package com.rg.lock.test;

import java.text.SimpleDateFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

@Slf4j
public class TimerTest {


  ScheduledExecutorService executorService = null;
  public static void main(String[] args) {

    ScheduledExecutorService mScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    mScheduledExecutorService.scheduleAtFixedRate(new Runnable() {
      @Override
      public void run() {

        System.out.println("run " + new SimpleDateFormat("yyyy-MM-dd HH:MM:ss").format(System.currentTimeMillis()));
      }
    }, 1, 1000, TimeUnit.MILLISECONDS);

    /*TimerTest timerTest = new TimerTest();

    for(int i = 25;i>=0; i--){
      timerTest.countDown(i);
    }*/

  }

  protected void countDown(int countDown){

    try {
      log.info("==========================value countDown:{}", countDown);
      if (executorService != null) {
        //executorService.shutdown();
      } else {
        executorService = new ScheduledThreadPoolExecutor(1,
            new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d")
                .daemon(true).build());
      }

      executorService.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
          log.info("时间到了，开始执行 NO MORE BET, countDown = {}", countDown);
          //log.info("递减={}", );
        }
      }, countDown, 1, TimeUnit.SECONDS);

    }catch(Exception e){
      e.printStackTrace();
    }
  }
}
