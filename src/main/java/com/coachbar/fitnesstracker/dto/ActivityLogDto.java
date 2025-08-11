package com.coachbar.fitnesstracker.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ActivityLogDto {
    @NotNull
    private Long userId;
    private Long workoutPlanId;
    @NotNull
    private LocalDate date;
    private Integer durationMinutes;
    private Integer caloriesBurned;
    private String notes;
}

