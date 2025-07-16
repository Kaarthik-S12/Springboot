package com.assignment.emp.controller;

import com.assignment.emp.Controller.UserController;
import com.assignment.emp.Model.User;
import com.assignment.emp.Service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testUpdateUser() throws Exception {
        User updatedUser = new User();
        updatedUser.setId(1L);
        updatedUser.setName("Updated Name");
        updatedUser.setRole("USER");

        Mockito.when(userService.updateUser(Mockito.eq(1L), Mockito.any(User.class)))
                .thenReturn(updatedUser);

        mockMvc.perform(put("/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Updated Name\",\"role\":\"USER\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Name"));
    }

    @Test
    public void testGetUsersByRole() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("John");
        user.setRole("ADMIN");

        List<User> users = Arrays.asList(user);

        Mockito.when(userService.findUsersByRole("ADMIN")).thenReturn(users);

        mockMvc.perform(get("/users/role/ADMIN"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John"));
    }
}
