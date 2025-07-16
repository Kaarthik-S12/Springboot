package com.assignment.emp.Controller;
import com.assignment.emp.Model.Todo;
import com.assignment.emp.Model.User;
import com.assignment.emp.Ropository.UserRepository;
import com.assignment.emp.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Todo>> getTodosForUser(@PathVariable Long userId) {
        return ResponseEntity.ok(todoService.getTodosByUser(userId));
    }
    @PostMapping("/user/{userId}")
    public ResponseEntity<Todo> createTodo(@PathVariable Long userId, @RequestBody Todo todo) {
        User user = userRepository.findById(userId).orElseThrow();
        return ResponseEntity.ok(todoService.createTodoForUser(todo, user));
    }
}