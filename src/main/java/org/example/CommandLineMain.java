package org.example;

import jakarta.transaction.Transactional;
import org.example.model.Comment;
import org.example.model.Post;
import org.example.repository.CommentRepository;
import org.example.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CommandLineMain implements CommandLineRunner {
    public static final Logger logger = LoggerFactory.getLogger(CommandLineMain.class);

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PostRepository postRepository;


    public static void main(String[] args) {
        SpringApplication.run(CommandLineMain.class, args);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Post post = new Post(1,"Title1","Content1","Author1");
        Post post1 = new Post(2,"Title2","Content2","Author2");
        logger.info("Saving Posts and Comments");
                postRepository.saveAll(Arrays.asList(post,post1));
                Comment comment1 = new Comment(1,"Comment1","Author1",post);
                Comment comment2 = new Comment(2,"Comment2","Author2",post1);
                Comment comment3 = new Comment(3,"Comment3","Author3",post1);
                commentRepository.saveAll(Arrays.asList(comment1,comment2,comment3));
        logger.info("Finding all comment objects");
        List<Comment> comments = commentRepository.findAll();
        for (Comment comment : comments) {
            logger.info("Comment [{}] from Post [{}]",comment.getContent(), comment.getPost().getTitle());
        }

    }
}