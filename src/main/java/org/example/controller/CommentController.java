package org.example.controller;

import jakarta.annotation.PostConstruct;
import org.example.model.Comment;
import org.example.model.Post;
import org.example.model.Todo;
import org.example.repository.CommentRepository;
import org.example.repository.TodoRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class CommentController {
    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    @PostConstruct
    public void init() {
//        commentRepository.saveAll(Arrays.asList(
//                new Comment(1,"Content1","Author1", new Post()),
//                new Comment(2,"Content2","Author2", new Post()),
//                new Comment(3,"Content3","Author3", new Post())));
    }

    @PreAuthorize("hasRole('MANAGER')")
    @GetMapping("/comments")
    public Iterable<Comment> getTodos() {
        return commentRepository.findAll();
    }
}
