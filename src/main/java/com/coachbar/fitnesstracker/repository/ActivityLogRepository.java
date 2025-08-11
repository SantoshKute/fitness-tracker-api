package com.coachbar.fitnesstracker.repository;

import com.coachbar.fitnesstracker.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {}
