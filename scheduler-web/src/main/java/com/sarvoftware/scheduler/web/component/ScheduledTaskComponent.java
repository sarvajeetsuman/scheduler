package com.sarvoftware.scheduler.web.component;

import com.sarvoftware.scheduler.model.RunningStatus;
import com.sarvoftware.scheduler.model.ScheduledTask;
import com.sarvoftware.scheduler.persistence.entities.ScheduledTaskEntity;
import com.sarvoftware.scheduler.persistence.repositories.ScheduledTaskRepo;
import com.sarvoftware.scheduler.web.factory.TaskFactory;
import com.sarvoftware.scheduler.web.scheduledtask.Task;
import com.sarvoftware.scheduler.web.service.ScheduledTaskService;
import com.sarvoftware.scheduler.web.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Scope("prototype")
public class ScheduledTaskComponent implements Runnable {

    private static Logger LOGGER = LoggerFactory.getLogger(ScheduledTaskComponent.class);

    @Autowired
    ScheduledTaskService scheduledTaskService;

    @Autowired
    ScheduledTaskRepo scheduledTaskRepo;

    @Autowired
    TaskFactory taskFactory;

    @Override
    public void run() {
        try {
            List<ScheduledTaskEntity> entities = scheduledTaskRepo.findByTriggerTimeLessThan(new Date());
            entities.stream().forEach(entity -> {
                entity.setRetries(entity.getRetries()+1);
                entity.setRunningStatus(RunningStatus.RUNNING);
                scheduledTaskRepo.save(entity);
                ScheduledTask scheduledTask = CommonUtil.convert(entity);
                Task task = taskFactory.getTaskClass(scheduledTask.getScheduledTaskType());
                Boolean response = task.processTask(scheduledTask);
                if (response) {
                    scheduledTask.setRunningStatus(RunningStatus.FINISHED);
                    scheduledTask.setLastRunTime(new Date());
                    scheduledTask.setTriggerTime(CommonUtil.getTriggerTime(scheduledTask.getTriggerTime(), scheduledTask.getFrequency()));
                } else if (scheduledTask.getRetries() != scheduledTask.getMaxRetries()){
                    scheduledTask.setRunningStatus(RunningStatus.FAILED);
                } else {
                    scheduledTask.setRunningStatus(RunningStatus.FAILED);
                    scheduledTask.setRetries(0);
                    scheduledTask.setTriggerTime(CommonUtil.getTriggerTime(scheduledTask.getTriggerTime(), scheduledTask.getFrequency()));
                }
                scheduledTaskService.save(scheduledTask);
            });
        } catch (Throwable t) {
            t.printStackTrace();
        }

    }



}
