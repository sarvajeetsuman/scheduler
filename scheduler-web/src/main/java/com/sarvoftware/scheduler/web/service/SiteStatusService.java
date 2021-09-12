package com.sarvoftware.scheduler.web.service;

import com.sarvoftware.scheduler.model.*;
import com.sarvoftware.scheduler.persistence.entities.SiteStatusEntity;
import com.sarvoftware.scheduler.persistence.repositories.SiteStatusRepo;
import com.sarvoftware.scheduler.web.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class SiteStatusService {

    @Autowired
    SiteStatusRepo siteStatusRepo;

    @Autowired
    ScheduledTaskService scheduledTaskService;

    public SiteStatusTaskResponse save(SiteStatusTaskRequest siteStatusTaskRequest) {
        SiteStatusEntity siteStatusEntity = CommonUtil.convert(siteStatusTaskRequest);
        siteStatusEntity = siteStatusRepo.save(siteStatusEntity);

        ScheduledTask scheduledTask = new ScheduledTask();
        scheduledTask.setScheduledTaskType(ScheduledTaskType.SITE_IS_UP);
        scheduledTask.setTaskId(siteStatusEntity.getId());
        scheduledTask.setRunningStatus(RunningStatus.CREATED);
        scheduledTask.setFrequency(siteStatusTaskRequest.getFrequency());
        scheduledTask.setTriggerTime(new Date());
        scheduledTaskService.save(scheduledTask);
        return CommonUtil.convert(siteStatusEntity);
    }

    public SiteStatusTaskResponse get(Long id) {
        Optional<SiteStatusEntity> siteStatusEntityOptional = siteStatusRepo.findById(id);
        if (!siteStatusEntityOptional.isPresent()) {
            return null;
        }
        return CommonUtil.convert(siteStatusEntityOptional.get());
    }

}
