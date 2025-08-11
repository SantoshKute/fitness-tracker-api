package com.coachbar.fitnesstracker.service;

import com.coachbar.fitnesstracker.entity.User;
import com.coachbar.fitnesstracker.entity.Role;
import com.coachbar.fitnesstracker.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock UserRepository repo;
    @Mock PasswordEncoder encoder;

    @InjectMocks UserService service;

    @Test
    void createUser_encodesPassword() {
        User input = new User();
        input.setUsername("john");
        input.setPassword("pass");
        input.setRole(Role.USER);

        when(encoder.encode("pass")).thenReturn("encoded");
        when(repo.save(any(User.class))).thenAnswer(i -> i.getArgument(0));

        User saved = service.create(input);

        assertThat(saved.getPassword()).isEqualTo("encoded");
        verify(repo).save(any(User.class));
    }

    @Test
    void getById_found() {
        User u = new User(); u.setId(1L);
        when(repo.findById(1L)).thenReturn(Optional.of(u));

        assertThat(service.getById(1L)).isSameAs(u);
    }
}
