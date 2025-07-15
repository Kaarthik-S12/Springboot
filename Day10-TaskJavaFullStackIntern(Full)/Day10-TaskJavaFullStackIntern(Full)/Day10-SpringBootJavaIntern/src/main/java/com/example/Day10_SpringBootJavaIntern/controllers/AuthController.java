package com.example.Day10-SpringBootIntern.controllers;

import com.example.Day10-SpringBootIntern.models.JwtResponse;
import com.example.Day10-SpringBootIntern.models.RegisterDetails;
import com.example.Day10-SpringBootIntern.models.UserDetailsDto;
import com.example.Day10-SpringBootIntern.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping
    public String addUserDetails(@RequestBody UserDetailsDto userDetails) {
        return authService.adUserDetails(userDetails);
    }
    @PostMapping("/login")
    public JwtResponse login(@RequestBody RegisterDetails userDetails) {
        return authService.authenticate(userDetails);
    }
}