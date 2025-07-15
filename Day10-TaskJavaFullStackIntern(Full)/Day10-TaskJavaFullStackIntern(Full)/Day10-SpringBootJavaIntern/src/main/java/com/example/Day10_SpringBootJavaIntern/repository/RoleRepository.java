package com.example.Day10-SpringBootIntern.repository;

import com.example.Day10-SpringBootIntern.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles,Integer> {
    Optional<Roles>findByRoleName(String roleName);
}