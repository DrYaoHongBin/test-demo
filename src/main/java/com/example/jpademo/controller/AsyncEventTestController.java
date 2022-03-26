package com.example.jpademo.controller;

import com.example.jpademo.event.AsyncTestEvent;
import com.example.jpademo.event.SessionCloseEvent;
import com.example.jpademo.event.SessionCreateEvent;
import com.example.jpademo.event.SessionJoinEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;

/**
 * @author yaohongbin
 * @date 2022/2/9
 * @desc
 */
@RequiredArgsConstructor
@RestController
@Slf4j
public class AsyncEventTestController {

    private final ApplicationContext applicationContext;

    @GetMapping("/testAsync")
    public void testAsync() {
        applicationContext.publishEvent(new AsyncTestEvent());
        log.info("publishEvent end");
    }

    @GetMapping("/testEvent")
    @Transactional
    public void testEvent() {
        applicationContext.publishEvent(new SessionCloseEvent());
        applicationContext.publishEvent(new SessionJoinEvent());
        applicationContext.publishEvent(new SessionCreateEvent());
    }
}
