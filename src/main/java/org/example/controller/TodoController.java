package org.example.controller;
import org.example.model.Todo;
import org.example.repository.TodoRepository;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.PostConstruct;
import java.util.Arrays;

@RestController
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostConstruct
    public void init() {
        todoRepository.saveAll(Arrays.asList(
                new Todo("First item", true),
                new Todo("Second item", true),
                new Todo("Third item", false)));
    }

    @GetMapping("/todos")
    public Iterable<Todo> getTodos() {
        return todoRepository.findAll();
    }
}
