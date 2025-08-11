package com.coachbar.fitnesstracker.service;

import com.coachbar.fitnesstracker.entity.WorkoutPlan;
import com.coachbar.fitnesstracker.exception.ResourceNotFoundException;
import com.coachbar.fitnesstracker.repository.WorkoutPlanRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutPlanService {
	@Autowired
    private WorkoutPlanRepository repo;
    public WorkoutPlan create(WorkoutPlan p) { return repo.save(p); }
    public List<WorkoutPlan> getAll() { return repo.findAll(); }
    public WorkoutPlan getById(Long id) { return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("WorkoutPlan not found")); }
    public WorkoutPlan update(Long id, WorkoutPlan payload) {
        WorkoutPlan db = getById(id);
        if (payload.getName() != null) db.setName(payload.getName());
        if (payload.getDescription() != null) db.setDescription(payload.getDescription());
        return repo.save(db);
    }
    public void delete(Long id) { repo.deleteById(id); }
}
