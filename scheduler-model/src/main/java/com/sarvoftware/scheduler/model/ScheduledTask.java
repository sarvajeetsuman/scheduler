package com.sarvoftware.scheduler.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScheduledTask {

    private Long id;

    private Long taskId;

    private ScheduledTaskType scheduledTaskType;

    private RunFrequencyType frequency;

    private Date lastRunTime;

    private Date triggerTime;

    private RunningStatus runningStatus;

    private Date createdTime;

    private Date updatedTime;

    private int retries;

    private int maxRetries;
}
