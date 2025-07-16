package com.assignment.emp.controller;

import com.assignment.emp.Controller.TodoController;
import com.assignment.emp.Model.Todo;
import com.assignment.emp.Model.User;
import com.assignment.emp.Service.TodoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TodoController.class)
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService todoService;

    @Test
    public void testUpdateTodo() throws Exception {
        Todo updatedTodo = new Todo();
        updatedTodo.setId(1L);                                                    //23EC023
        updatedTodo.setTask("Updated Task");
        updatedTodo.setCompleted(true);

        Mockito.when(todoService.updateTodo(Mockito.eq(1L), Mockito.any(Todo.class)))
                .thenReturn(updatedTodo);

        mockMvc.perform(put("/todos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"task\":\"Updated Task\",\"completed\":true}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.task").value("Updated Task"))
                .andExpect(jsonPath("$.completed").value(true));
    }

    @Test
    public void testGetTodosByUserId() throws Exception {
        Todo todo = new Todo();
        todo.setId(1L);
        todo.setTask("Sample Task");
        todo.setCompleted(false);

        User user = new User();
        user.setId(1L);
        user.setName("John");
        user.setRole("USER");
        todo.setUser(user);

        List<Todo> todos = Arrays.asList(todo);

        Mockito.when(todoService.getTodosByUser(1L)).thenReturn(todos);

        mockMvc.perform(get("/todos/user/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].task").value("Sample Task"))
                .andExpect(jsonPath("$[0].completed").value(false));
    }
}
