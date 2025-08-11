package com.coachbar.fitnesstracker.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class WorkoutPlanDto {
    @NotBlank
    private String name;
    private String description;
    private Long ownerId;
}
