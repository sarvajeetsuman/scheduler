package com.sarvoftware.scheduler.persistence.repositories;

import com.sarvoftware.scheduler.model.ScheduledLog;
import com.sarvoftware.scheduler.persistence.entities.ScheduledLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduledLogRepo extends JpaRepository<ScheduledLogEntity, Long> {
}
