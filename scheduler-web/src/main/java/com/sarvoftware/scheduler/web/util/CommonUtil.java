package com.sarvoftware.scheduler.web.util;

import com.sarvoftware.scheduler.model.*;
import com.sarvoftware.scheduler.persistence.entities.ScheduledTaskEntity;
import com.sarvoftware.scheduler.persistence.entities.SiteStatusEntity;

import java.util.Calendar;
import java.util.Date;

public class CommonUtil {

    public static Date getTriggerTime(Date lastDate, RunFrequencyType frequency) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastDate);
        if (frequency == RunFrequencyType.HOURLY) {
            calendar.add(Calendar.HOUR_OF_DAY,1);
        } else if (frequency == RunFrequencyType.DAILY) {
            calendar.add(Calendar.DATE, 1);
        } else if (frequency == RunFrequencyType.WEEKLY) {
            calendar.add(Calendar.WEEK_OF_YEAR, 1);
        } else if (frequency == RunFrequencyType.MONTHLY) {
            calendar.add(Calendar.MONTH, 1);
        } else {
            return new Date();
        }
        return calendar.getTime();
    }

    public static ScheduledTaskEntity convert(ScheduledTask scheduledTask) {
        ScheduledTaskEntity scheduledTaskEntity = new ScheduledTaskEntity();
        scheduledTaskEntity.setScheduledTaskType(ScheduledTaskType.SITE_IS_UP);
        scheduledTaskEntity.setMaxRetries(scheduledTask.getMaxRetries());
        scheduledTaskEntity.setRetries(scheduledTask.getRetries());
        scheduledTaskEntity.setTaskId(scheduledTask.getTaskId());
        scheduledTaskEntity.setFrequency(scheduledTask.getFrequency());
        scheduledTaskEntity.setRunningStatus(scheduledTask.getRunningStatus());
        scheduledTaskEntity.setTriggerTime(scheduledTask.getTriggerTime());
        scheduledTaskEntity.setLastRunTime(scheduledTask.getLastRunTime());
        scheduledTaskEntity.setId(scheduledTask.getId());
        scheduledTaskEntity.setCreatedTime(scheduledTask.getCreatedTime());
        scheduledTaskEntity.setUpdatedTime(scheduledTask.getUpdatedTime());
        return scheduledTaskEntity;
    }

    public static ScheduledTask convert(ScheduledTaskEntity scheduledTaskEntity) {
        ScheduledTask scheduledTask = new ScheduledTask();
        scheduledTask.setMaxRetries(scheduledTask.getMaxRetries());
        scheduledTask.setRetries(scheduledTask.getRetries());
        scheduledTask.setScheduledTaskType(scheduledTaskEntity.getScheduledTaskType());
        scheduledTask.setTaskId(scheduledTaskEntity.getTaskId());
        scheduledTask.setFrequency(scheduledTaskEntity.getFrequency());
        scheduledTask.setRunningStatus(scheduledTaskEntity.getRunningStatus());
        scheduledTask.setTriggerTime(scheduledTaskEntity.getTriggerTime());
        scheduledTask.setLastRunTime(scheduledTaskEntity.getLastRunTime());
        scheduledTask.setId(scheduledTaskEntity.getId());
        scheduledTask.setCreatedTime(scheduledTaskEntity.getCreatedTime());
        scheduledTask.setUpdatedTime(scheduledTaskEntity.getUpdatedTime());
        return scheduledTask;
    }

    public static SiteStatusEntity convert(SiteStatusTaskRequest siteStatusTaskRequest) {
        SiteStatusEntity siteStatusEntity = new SiteStatusEntity();
        siteStatusEntity.setId(siteStatusTaskRequest.getId());
        siteStatusEntity.setUrl(siteStatusTaskRequest.getUrl());
        return siteStatusEntity;
    }

    public static SiteStatusTaskResponse convert(SiteStatusEntity siteStatusEntity) {
        SiteStatusTaskResponse siteStatusTaskResponse = new SiteStatusTaskResponse();
        siteStatusTaskResponse.setId(siteStatusEntity.getId());
        siteStatusTaskResponse.setUrl(siteStatusEntity.getUrl());
        siteStatusTaskResponse.setStatus(siteStatusEntity.isStatus());
        return siteStatusTaskResponse;
    }

}
