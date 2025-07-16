package com.assignment.emp.service;

import com.assignment.emp.Model.User;
import com.assignment.emp.Ropository.UserRepository;
import com.assignment.emp.Service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testUpdateUser() {
        User existingUser = new User();
        existingUser.setId(1L);
        existingUser.setName("Old Name");
        existingUser.setRole("USER");

        User updatedData = new User();
        updatedData.setName("New Name");
        updatedData.setRole("ADMIN");

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(existingUser);

        User result = userService.updateUser(1L, updatedData);

        assertEquals("New Name", result.getName());
        assertEquals("ADMIN", result.getRole());
    }

    @Test
    public void testFindUsersByRole() {
        User user = new User();
        user.setId(1L);
        user.setName("John");
        user.setRole("ADMIN");

        List<User> users = Arrays.asList(user);

        Mockito.when(userRepository.findByRole("ADMIN")).thenReturn(users);

        List<User> result = userService.findUsersByRole("ADMIN");

        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getName());
    }
}
