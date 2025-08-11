package com.coachbar.fitnesstracker.controller;

import com.coachbar.fitnesstracker.entity.ActivityLog;
import com.coachbar.fitnesstracker.service.ActivityLogService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/activity-logs")
@RequiredArgsConstructor
public class ActivityLogController {
	@Autowired
    private ActivityLogService service;
    @PostMapping
    public ResponseEntity<ActivityLog> create(@RequestBody ActivityLog a){ return ResponseEntity.status(HttpStatus.CREATED).body(service.create(a)); }
    @GetMapping
    public List<ActivityLog> all(){ return service.getAll(); }
    @GetMapping("/{id}")
    public ActivityLog one(@PathVariable Long id){ return service.getById(id); }
    @PutMapping("/{id}")
    public ActivityLog update(@PathVariable Long id, @RequestBody ActivityLog a){ return service.update(id, a); }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){ service.delete(id); return ResponseEntity.noContent().build(); }
}
