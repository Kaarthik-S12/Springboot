package com.assignment.emp.Service;

import com.assignment.emp.Model.Todo;
import com.assignment.emp.Model.User;
import com.assignment.emp.Ropository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo createTodoForUser(Todo todo, User user) {
        todo.setUser(user);
        return todoRepository.save(todo);
    }

    public List<Todo> getTodosByUser(Long userId) {
        return todoRepository.findByUserId(userId);
    }

    public Todo updateTodo(Long id, Todo updatedTodo) {
        return todoRepository.findById(id).map(todo -> {    //23EC023
            todo.setTask(updatedTodo.getTask());
            todo.setCompleted(updatedTodo.isCompleted());
            return todoRepository.save(todo);
        }).orElse(null);
    }
}
