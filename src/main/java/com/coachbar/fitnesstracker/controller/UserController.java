package com.coachbar.fitnesstracker.controller;

import com.coachbar.fitnesstracker.entity.User;
import com.coachbar.fitnesstracker.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Validated
public class UserController {
	@Autowired
    private  UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> create(@RequestBody User u){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(u));
    }

    @GetMapping
    public List<User> all(){ return userService.getAll(); }

    @GetMapping("/{id}")
    public User one(@PathVariable Long id){ return userService.getById(id); }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User u){ return userService.update(id, u); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){ userService.delete(id); return ResponseEntity.noContent().build(); }
}
