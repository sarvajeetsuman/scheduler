package com.sarvoftware.scheduler.web.service;

import com.sarvoftware.scheduler.model.ScheduledTask;
import com.sarvoftware.scheduler.persistence.entities.ScheduledTaskEntity;
import com.sarvoftware.scheduler.persistence.repositories.ScheduledTaskRepo;
import com.sarvoftware.scheduler.web.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {

    @Autowired
    ScheduledTaskRepo scheduledTaskRepo;

    public ScheduledTask save(ScheduledTask scheduledTask) {
        ScheduledTaskEntity scheduledTaskEntity = CommonUtil.convert(scheduledTask);
        scheduledTaskEntity = scheduledTaskRepo.save(scheduledTaskEntity);
        return CommonUtil.convert(scheduledTaskEntity);
    }


}
