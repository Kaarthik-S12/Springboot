package com.assignment.emp.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "app_user") // renamed from 'user' to avoid SQL reserved keyword
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Todo> todos;
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getRole() {
        return role;
    }
    public List<Todo> getTodos() {
        return todos;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}