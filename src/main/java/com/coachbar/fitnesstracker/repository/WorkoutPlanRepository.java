package com.coachbar.fitnesstracker.repository;

import com.coachbar.fitnesstracker.entity.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long> {}
