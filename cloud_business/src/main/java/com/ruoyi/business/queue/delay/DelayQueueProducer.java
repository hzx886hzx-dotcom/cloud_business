package com.ruoyi.business.queue.delay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.concurrent.DelayQueue;

@Slf4j
@Component
public class DelayQueueProducer {

    @Autowired
    private DelayQueue<DelayedTask> delayQueue;

    public boolean addTask(DelayedTask task) {
        try {
            boolean result = delayQueue.offer(task);
            if (result) {
                log.info("✅ 延迟任务添加成功 | taskId: {} | 执行时间: {}",
                        task.getTaskId(),
                        new java.util.Date(task.getDelayTime()));
            } else {
                log.warn("⚠️ 延迟任务添加失败 | taskId: {}", task.getTaskId());
            }
            return result;
        } catch (Exception e) {
            log.error("❌ 添加延迟任务异常 | task: {}", task, e);
            return false;
        }
    }

    public int getQueueSize() {
        return delayQueue.size();
    }
}
