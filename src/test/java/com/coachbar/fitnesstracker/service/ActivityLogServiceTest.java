package com.coachbar.fitnesstracker.service;

import com.coachbar.fitnesstracker.entity.ActivityLog;
import com.coachbar.fitnesstracker.repository.ActivityLogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ActivityLogServiceTest {

    @Mock ActivityLogRepository repo;

    @InjectMocks ActivityLogService service;

    @Test
    void createActivityLog_savesEntity() {
        ActivityLog log = new ActivityLog();
        when(repo.save(log)).thenReturn(log);

        assertThat(service.create(log)).isSameAs(log);
    }

    @Test
    void getById_returnsEntity() {
        ActivityLog log = new ActivityLog();
        when(repo.findById(1L)).thenReturn(Optional.of(log));

        assertThat(service.getById(1L)).isSameAs(log);
    }
}
