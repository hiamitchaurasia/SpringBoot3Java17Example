package com.hiamitchaurasia.example1.controller;

import com.hiamitchaurasia.example1.repository.PostRepository;
import jakarta.annotation.PostConstruct;
import com.hiamitchaurasia.example1.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @PostConstruct
    public void init() {
//        postRepository.saveAll(Arrays.asList(
//                new Post(1,"Title","Content1","Author1",new Comment()),
//                new Comment(2,"Content2","Author2", new Post()),
//                new Comment(3,"Content3","Author3", new Post())));
    }

    @GetMapping("/posts")
    public Iterable<Post> getTodos() {
        return postRepository.findAll();
    }
}
