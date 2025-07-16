package com.assignment.emp.service;

import com.assignment.emp.Model.Todo;
import com.assignment.emp.Model.User;
import com.assignment.emp.Ropository.TodoRepository;
import com.assignment.emp.Service.TodoService;
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
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    public void testUpdateTodo() {
        Todo existingTodo = new Todo();
        existingTodo.setId(1L);
        existingTodo.setTask("Old Task");
        existingTodo.setCompleted(false);

        Todo updatedTodo = new Todo();
        updatedTodo.setTask("New Task");
        updatedTodo.setCompleted(true);

        Mockito.when(todoRepository.findById(1L)).thenReturn(Optional.of(existingTodo));
        Mockito.when(todoRepository.save(Mockito.any(Todo.class))).thenReturn(existingTodo);

        Todo result = todoService.updateTodo(1L, updatedTodo);

        assertEquals("New Task", result.getTask());
        assertTrue(result.isCompleted());
    }

    @Test
    public void testGetTodosByUser() {
        User user = new User();
        user.setId(1L);

        Todo todo1 = new Todo();
        todo1.setId(1L);
        todo1.setTask("Task 1");
        todo1.setUser(user);

        List<Todo> todoList = Arrays.asList(todo1);

        Mockito.when(todoRepository.findByUserId(1L)).thenReturn(todoList);

        List<Todo> result = todoService.getTodosByUser(1L);

        assertEquals(1, result.size());
        assertEquals("Task 1", result.get(0).getTask());
    }

    @Test
    public void testCreateTodoForUser() {
        User user = new User();
        user.setId(1L);

        Todo todo = new Todo();
        todo.setTask("New Task");
        todo.setUser(user);

        Mockito.when(todoRepository.save(todo)).thenReturn(todo);

        Todo result = todoService.createTodoForUser(todo, user);

        assertEquals("New Task", result.getTask());
        assertEquals(user, result.getUser());
    }
}
