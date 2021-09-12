package com.sarvoftware.scheduler.persistence.repositories;

import com.sarvoftware.scheduler.persistence.entities.SiteStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteStatusRepo extends JpaRepository<SiteStatusEntity, Long> {
}
