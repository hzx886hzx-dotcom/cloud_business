package com.ruoyi.business.queue.delay;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@Component
@RequiredArgsConstructor
public class DelayQueueConsumer {

    private final DelayQueue<DelayedTask> delayQueue;

    private final AtomicBoolean running = new AtomicBoolean(true);

    private final ThreadPoolTaskExecutor taskHandlerExecutor = new ThreadPoolTaskExecutor();

    @PostConstruct
    public void init() {
        taskHandlerExecutor.setCorePoolSize(4);
        taskHandlerExecutor.setMaxPoolSize(6);
        taskHandlerExecutor.setQueueCapacity(1000);
        taskHandlerExecutor.setThreadNamePrefix("delay-queue-handler-");
        taskHandlerExecutor.setWaitForTasksToCompleteOnShutdown(true);
        taskHandlerExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskHandlerExecutor.setAwaitTerminationSeconds(60);
        taskHandlerExecutor.setAllowCoreThreadTimeOut(true);
        taskHandlerExecutor.initialize();

        run();
    }

    public void run() {
        log.info("🚀 延迟队列消费者启动成功");

        while (running.get() && !Thread.currentThread().isInterrupted()) {
            try {
                // 阻塞获取任务，最多等待1秒
                DelayedTask task = delayQueue.poll(1, TimeUnit.SECONDS);

                if (task != null) {
                    log.debug("📥 获取到延迟任务 | taskId: {} | 延迟: {}ms",
                            task.getTaskId(),
                            System.currentTimeMillis() - task.getDelayTime());

                    // 异步处理任务
                    taskHandlerExecutor.execute(() -> {
                        processTask(task);
                    });
                }
            } catch (InterruptedException e) {
                log.warn("⏸️ 延迟队列消费者被中断");
                Thread.currentThread().interrupt();
                break;
            } catch (Exception e) {
                log.error("❌ 延迟队列消费者异常", e);
                try {
                    Thread.sleep(1000); // 避免死循环
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        log.info("🛑 延迟队列消费者已停止");
    }

    private void processTask(DelayedTask task) {
        String taskId = task.getTaskId();


    }

    private void handleTaskFailure(DelayedTask task) {

    }

    @PreDestroy
    public void shutdown() {
        running.set(false);
        log.info("🔄 延迟队列消费者正在关闭...");
        taskHandlerExecutor.shutdown();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}