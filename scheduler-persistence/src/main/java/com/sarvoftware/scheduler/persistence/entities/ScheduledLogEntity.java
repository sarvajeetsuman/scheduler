package com.sarvoftware.scheduler.persistence.entities;

import com.sarvoftware.scheduler.model.RunningStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ScheduledLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int taskId;

    private RunningStatus runningStatus;

}
