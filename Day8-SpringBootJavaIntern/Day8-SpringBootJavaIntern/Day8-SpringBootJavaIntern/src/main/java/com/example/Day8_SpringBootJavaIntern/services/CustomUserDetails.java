package com.example.Day7_SpringBootJavaIntern.services;

import com.example.Day7_SpringBootJavaIntern.models.Todo;
import com.example.Day7_SpringBootJavaIntern.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getTodosByEmployeeId(Long employeeId) {
        return todoRepository.findByEmployeeId(employeeId);
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo updateTodo(Long id, Todo updatedTodo) {
        return todoRepository.findById(id).map(todo -> {
            todo.setDescription(updatedTodo.getDescription());
            todo.setDone(updatedTodo.isDone());
            return todoRepository.save(todo);
        }).orElseThrow(() -> new RuntimeException("Todo not found with ID: " + id));
    }

    public void deleteTodo(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new RuntimeException("Todo not found with ID: " + id);
        }
        todoRepository.deleteById(id);
    }
}
