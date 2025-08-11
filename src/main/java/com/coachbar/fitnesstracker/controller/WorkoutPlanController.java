package com.coachbar.fitnesstracker.controller;

import com.coachbar.fitnesstracker.entity.WorkoutPlan;
import com.coachbar.fitnesstracker.service.WorkoutPlanService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/workout-plans")
@RequiredArgsConstructor
public class WorkoutPlanController {
	@Autowired
    private WorkoutPlanService service;

    @PostMapping
    public ResponseEntity<WorkoutPlan> create(@RequestBody WorkoutPlan p){ return ResponseEntity.status(HttpStatus.CREATED).body(service.create(p)); }
    @GetMapping
    public List<WorkoutPlan> all(){ return service.getAll(); }
    @GetMapping("/{id}")
    public WorkoutPlan one(@PathVariable Long id){ return service.getById(id); }
    @PutMapping("/{id}")
    public WorkoutPlan update(@PathVariable Long id, @RequestBody WorkoutPlan p){ return service.update(id, p); }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){ service.delete(id); return ResponseEntity.noContent().build(); }
}
