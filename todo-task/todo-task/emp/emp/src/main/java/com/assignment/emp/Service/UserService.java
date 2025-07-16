package com.assignment.emp.Service;

import com.assignment.emp.Model.User;
import com.assignment.emp.Ropository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User updateUser(Long id, User updatedUser) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(updatedUser.getName());
        user.setRole(updatedUser.getRole());
        return userRepository.save(user);
    }
    public List<User> findUsersByRole(String role) {
        return userRepository.findByRole(role);
    }
}
