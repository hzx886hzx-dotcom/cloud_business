package com.ruoyi.business.queue.delay;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.DelayQueue;

@Configuration
public class DelayQueueConfig {

    /**
     * 创建全局延迟队列实例
     */
    @Bean
    public DelayQueue<DelayedTask> delayQueue() {
        return new DelayQueue<>();
    }
}