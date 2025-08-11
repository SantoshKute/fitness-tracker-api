package com.coachbar.fitnesstracker.service;

import com.coachbar.fitnesstracker.entity.User;
import com.coachbar.fitnesstracker.exception.ResourceNotFoundException;
import com.coachbar.fitnesstracker.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;

    public User create(User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return userRepository.save(u);
    }
    public List<User> getAll() { return userRepository.findAll(); }
    public User getById(Long id) { return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found")); }
    public User update(Long id, User payload) {
        User db = getById(id);
        if (payload.getEmail() != null) db.setEmail(payload.getEmail());
        return userRepository.save(db);
    }
    public void delete(Long id) { userRepository.deleteById(id); }
}
