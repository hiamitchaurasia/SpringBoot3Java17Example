package com.hiamitchaurasia.example1.controller;

import com.hiamitchaurasia.example1.repository.CommentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;

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

//    @PreAuthorize("hasRole('MANAGER')")
//    @GetMapping("/comments")
//    public Iterable<Comment> getTodos() {
//        return commentRepository.findAll();
//    }
}
