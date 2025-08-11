package com.coachbar.fitnesstracker.controller;

import com.coachbar.fitnesstracker.entity.User;
import com.coachbar.fitnesstracker.entity.Role;
import com.coachbar.fitnesstracker.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
//@WithMockUser(username = "testuser", roles = {"USER"})
class UserControllerTest {

    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper mapper;

    @MockBean UserService service;

    @Test
    void getAll_returnsList() throws Exception {
        when(service.getAll()).thenReturn(List.of(new User()));

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk());
    }

    @Test
    void create_returnsCreatedUser() throws Exception {
        User u = new User(); u.setUsername("john"); u.setPassword("pass"); u.setRole(Role.USER);
        when(service.create(any(User.class))).thenReturn(u);

        mockMvc.perform(post("/api/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(u)))
                .andExpect(status().isCreated());
    }
}
