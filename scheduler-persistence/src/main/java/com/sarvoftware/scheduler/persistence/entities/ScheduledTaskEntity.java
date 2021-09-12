package com.sarvoftware.scheduler.persistence.entities;

import com.sarvoftware.scheduler.model.RunFrequencyType;
import com.sarvoftware.scheduler.model.RunningStatus;
import com.sarvoftware.scheduler.model.ScheduledTaskType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ScheduledTaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long taskId;

    private ScheduledTaskType scheduledTaskType;

    @Enumerated(EnumType.STRING)
    private RunFrequencyType frequency;

    private Date lastRunTime;

    private Date triggerTime;

    @Enumerated(EnumType.STRING)
    private RunningStatus runningStatus;

    private Date createdTime;

    private Date updatedTime;

    private int retries;

    private int maxRetries;

}
