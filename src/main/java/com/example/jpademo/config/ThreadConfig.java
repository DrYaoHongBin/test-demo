package com.example.jpademo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author lizhongjian
 * @create: 2019-08-22 14:55
 */
@Configuration
@EnableScheduling
@EnableAsync
@EnableTransactionManagement
public class ThreadConfig {

    @Value("${push.thread.pool.coreSize:20}")
    private int pushThreadPoolCoreSize;

    @Value("${push.thread.pool.maxSize:40}")
    private int pushThreadPoolMaxSize;

    /**
     * 发送mq消息的线程池
     */
    @Bean
    public Executor pushMessageThread() {
        return getPushMessageExecutor();
    }

    /**
     * 远程调用线程池
     */
    @Bean
    public Executor remoteThread() {
//        return getPoolTaskExecutor();
        return new SimpleAsyncTaskExecutor();
    }

    /**
     * 会话过期线程池
     */
    @Bean
    public Executor taskSessionExpireThread() {
        return getTenPoolTaskExecutor();
    }

    /**
     * 会话重连检查线程池
     */
    @Bean
    public Executor taskSessionEndpointRecoverCheckThread() {
        return getPoolTaskExecutor();
    }

    /**
     * 离开会话线程池
     */
    @Bean
    public Executor quitSessionThread() {
        return getPoolTaskExecutor();
    }

    /**
     * 邀请定时任务线程池
     */
    @Bean
    public Executor taskInviteThread() {
        return getPoolTaskExecutor();
    }

    /**
     * 重新加入会话线程池
     */
    @Bean
    public Executor rejoinThread() {
        return getPoolTaskExecutor();
    }

    /**
     * 号码回收器的执行线程。 号码回收不会同时触发，且不需要并发回收，因此只需要一个回收线程即可
     */
    @Bean
    public Executor taskNumberRecyleThread() {
        return Executors.newSingleThreadExecutor();
    }

    /**
     * 断线重连话线程池
     */
    @Bean
    public Executor endpointRecoveringThread() {
        return getPoolTaskExecutor();
    }

    private ThreadPoolTaskExecutor getTenPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(100);
        executor.setKeepAliveSeconds(60);
        // 设置线程池的拒绝策略：默认的AbortPolicy, 拿不到就立即丢弃，不符合我们实际场景。
        // 修改成CallerRunsPolicy，该策略较为平缓策略，当线程数达到上限且等待队列达到上限时，交由主线程去执行。
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    private ThreadPoolTaskExecutor getPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(60);
        executor.setQueueCapacity(100);
        executor.setKeepAliveSeconds(60);
        // 设置线程池的拒绝策略：默认的AbortPolicy, 拿不到就立即丢弃，不符合我们实际场景。
        // 修改成CallerRunsPolicy，该策略较为平缓策略，当线程数达到上限且等待队列达到上限时，交由主线程去执行。
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    private ThreadPoolTaskExecutor getPushMessageExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(pushThreadPoolCoreSize);
        executor.setMaxPoolSize(pushThreadPoolMaxSize);
        executor.setQueueCapacity(1000);
        executor.setKeepAliveSeconds(60);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
