package com.sarvoftware.scheduler.web.config;

import com.sarvoftware.scheduler.model.ScheduledTaskType;
import com.sarvoftware.scheduler.web.component.ScheduledTaskComponent;
import com.sarvoftware.scheduler.web.scheduledtask.Impl.SiteIsUpComponent;
import com.sarvoftware.scheduler.web.scheduledtask.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Configuration
public class AppConfig {

    @Autowired
    ScheduledTaskComponent scheduledTaskComponent;

    @Bean(name = "scheduled_thead_pool")
    public ExecutorService threadPool() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(scheduledTaskComponent, 0, 5, TimeUnit.SECONDS);
        return executorService;
    }

    @Bean(name = "task_instances")
    public Map<ScheduledTaskType, Task> taskMap(SiteIsUpComponent siteIsUpComponent) {
        Map<ScheduledTaskType, Task> taskMap = new HashMap<>();
        taskMap.put(ScheduledTaskType.SITE_IS_UP, siteIsUpComponent);
        return taskMap;
    }

}
