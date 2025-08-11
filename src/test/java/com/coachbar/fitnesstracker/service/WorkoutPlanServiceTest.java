package com.coachbar.fitnesstracker.service;

import com.coachbar.fitnesstracker.entity.WorkoutPlan;
import com.coachbar.fitnesstracker.repository.WorkoutPlanRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WorkoutPlanServiceTest {

    @Mock WorkoutPlanRepository repo;

    @InjectMocks WorkoutPlanService service;

    @Test
    void createWorkoutPlan_savesEntity() {
        WorkoutPlan wp = new WorkoutPlan();
        when(repo.save(wp)).thenReturn(wp);

        assertThat(service.create(wp)).isSameAs(wp);
    }

    @Test
    void getById_returnsEntity() {
        WorkoutPlan wp = new WorkoutPlan();
        when(repo.findById(1L)).thenReturn(Optional.of(wp));

        assertThat(service.getById(1L)).isSameAs(wp);
    }
}
