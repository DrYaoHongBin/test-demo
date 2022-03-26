package com.example.jpademo;

import org.junit.jupiter.api.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yaohongbin
 * @date 2022/3/19
 * @desc
 */
public class ThreadPoolTest {

    @Test
    public void test1() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));
        int i = 1;
        while (i < 10) {
            threadPoolExecutor.submit(() -> {
                System.out.println("执行任务");
            });
            i++;
        }

    }
}
