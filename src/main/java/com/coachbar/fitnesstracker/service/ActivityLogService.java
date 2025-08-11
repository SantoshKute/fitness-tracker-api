package com.coachbar.fitnesstracker.service;

import com.coachbar.fitnesstracker.entity.ActivityLog;
import com.coachbar.fitnesstracker.exception.ResourceNotFoundException;
import com.coachbar.fitnesstracker.repository.ActivityLogRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityLogService {
	@Autowired
    private ActivityLogRepository repo;
    public ActivityLog create(ActivityLog a) { return repo.save(a); }
    public List<ActivityLog> getAll() { return repo.findAll(); }
    public ActivityLog getById(Long id) { return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("ActivityLog not found")); }
    public ActivityLog update(Long id, ActivityLog payload) {
        ActivityLog db = getById(id);
        if (payload.getNotes() != null) db.setNotes(payload.getNotes());
        if (payload.getDurationMinutes() != null) db.setDurationMinutes(payload.getDurationMinutes());
        return repo.save(db);
    }
    public void delete(Long id) { repo.deleteById(id); }
}
