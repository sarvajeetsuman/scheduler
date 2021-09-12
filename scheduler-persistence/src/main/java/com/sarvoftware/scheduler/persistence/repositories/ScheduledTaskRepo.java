package com.sarvoftware.scheduler.persistence.repositories;

import com.sarvoftware.scheduler.persistence.entities.ScheduledTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScheduledTaskRepo extends JpaRepository<ScheduledTaskEntity, Long> {
    List<ScheduledTaskEntity> findByTriggerTimeLessThan(Date triggerTime);
}
