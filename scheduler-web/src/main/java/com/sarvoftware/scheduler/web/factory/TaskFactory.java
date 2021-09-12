package com.sarvoftware.scheduler.web.factory;

import com.sarvoftware.scheduler.model.ScheduledTaskType;
import com.sarvoftware.scheduler.web.scheduledtask.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TaskFactory {

    @Autowired
    @Qualifier(value = "task_instances")
    public Map<ScheduledTaskType, Task> taskMap;

    public Task getTaskClass(ScheduledTaskType scheduledTaskType) {
        return taskMap.get(scheduledTaskType);
    }

}
