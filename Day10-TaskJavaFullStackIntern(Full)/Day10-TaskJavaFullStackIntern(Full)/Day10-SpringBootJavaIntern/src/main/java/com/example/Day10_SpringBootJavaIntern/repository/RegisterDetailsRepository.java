package com.example.Day10-SpringBootIntern.repository;

import com.example.Day10-SpringBootIntern.models.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;


public interface RegisterDetailsRepository extends JpaRepository<RegisterDetails,Integer> {

    RegisterDetails findByEmail(String email);


    RegisterDetails findByUserName(String userName);
    @Query("SELECT r.roleName FROM RegisterDetails u JOIN u.roles r WHERE u.userName = :userName")
    Set<String> getRoleNamesByUserName(String userName);
}