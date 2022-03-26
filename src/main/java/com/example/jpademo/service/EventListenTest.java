package com.example.jpademo.service;

import com.example.jpademo.event.SessionCloseEvent;
import com.example.jpademo.event.SessionCreateEvent;
import com.example.jpademo.event.SessionJoinEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author yaohongbin
 * @date 2022/3/24
 * @desc
 */
@Component
@Slf4j
public class EventListenTest {

    @TransactionalEventListener
    @Order(4)
    public void onCreateEvent(SessionCreateEvent event) throws InterruptedException {
        log.info("create1 事件先到");
        Thread.sleep(1);
    }

    @TransactionalEventListener
    @Order(5)
    public void onCreateEvent2(SessionCreateEvent event) throws InterruptedException {
        log.info("create2 事件先到");
        Thread.sleep(1);
    }

    @TransactionalEventListener
//    @Order(10000)
    public void onJoinEvent(SessionJoinEvent event) throws InterruptedException {
        log.info("join 事件先到");
        Thread.sleep(1);
    }

    @TransactionalEventListener
    public void onSessionCloseEvent(SessionCloseEvent event) throws InterruptedException {
        log.info("close 事件先到");
        Thread.sleep(1);
    }
}
