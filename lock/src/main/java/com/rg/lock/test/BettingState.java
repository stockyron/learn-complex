package com.rg.lock.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.og.ogplus.common.message.ExtendMessage;
import com.og.ogplus.common.message.Message;
import com.og.ogplus.common.message.TimerMessage;
import com.og.ogplus.common.message.UpdateStatusMessage;
import com.og.ogplus.game.server.enums.GameStateType;
import com.og.ogplus.game.server.event.ExtendChangedEvent;
import com.og.ogplus.game.server.event.TimerUpdatedEvent;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

@Slf4j
public class BettingState<T extends CasinoGame> extends AbstractGameState<T> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    //number 是自己记录的倒计时一个数字
    int number;

    @Override
    public GameStateType getStateType() {
        return GameStateType.BETTING;
    }


    @Override
    public void handleGameMessage(Message message) {
        super.handleGameMessage(message);
        if (message instanceof TimerMessage) {
            handleTimerMessage((TimerMessage) message);
        } else if (message instanceof ExtendMessage) {
            handleExtendMessage((ExtendMessage) message);
        }
    }

    protected void handleTimerMessage(TimerMessage message) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("timer", message.getCountDown());
        getGame().setDetails(objectNode);

        number = message.getCountDown();
        //检验倒计时 是否正确
        countDown(message.getCountDown());

        getGame().dispatchGameEvent(
                TimerUpdatedEvent.builder()
                        .gameIdentity(getGame().getGameId())
                        .countDown(Duration.ofSeconds(message.getCountDown()))
                        .build());
    }

    @Override
    protected void handleUpdateStatusMessage(UpdateStatusMessage message) {
        if ("NO MORE BETS".equals(message.getStatus())) {
            changeGameState(getDealingStateClass());
        }
    }

    protected void handleExtendMessage(ExtendMessage message) {
        getGame().setExtendable(message.isExtendable());
        getGame().dispatchGameEvent(
                ExtendChangedEvent.builder()
                        .gameIdentity(getGame().getGameId())
                        .extendable(message.isExtendable())
                        .build());
    }

    protected Class<? extends AbstractDealingState> getDealingStateClass() {
        return AbstractDealingState.class;
    }

    /**
     * 倒计时
     * @param countDown
     */
    ScheduledExecutorService executorService = null;
    protected void countDown(int countDown){

        log.info("==========================value countDown:{}", countDown);
        if(executorService != null) {
            if(executorService.isShutdown()){
                log.info("executeorService 是否 shutdown ====================");
            }
            //报错
            //executorService.shutdown();
        }else {
            executorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().build());
        }

        log.info("开始定时器任务,每秒执行一次");
        executorService.scheduleAtFixedRate(new CountDownClass(countDown),  1000, 1000, TimeUnit.MILLISECONDS);//毫秒数

    }

    class CountDownClass implements Runnable {
        // count 是递减正常的数字
        int count;

        public CountDownClass (int countDown){
            this.count = countDown;
        }
        @Override
        public void run() {
            try {
                log.info("开始进入 CountDownClass 类.....时间:{}", LocalDateTime
                    .now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM:ss")));
                Thread.sleep(3000);
                log.info("=====================number = {}, count = {}", number, count);

                log.info("线程休眠之后的时间:{}", LocalDateTime
                    .now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM:ss")));

                if (number == count) {
                    log.info("number 与 count 相等");
                } else {
                    log.info("number 与 count 不相等");
                }

                log.info("进入到 countDown run....方法中:{}", count);
                count--;
                log.info("倒计时的数字 count={}, countDown={}", count);

                log.info("count 减去之后的时间={} ", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM:ss")));

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
