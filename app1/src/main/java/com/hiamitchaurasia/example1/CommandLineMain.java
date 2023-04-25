package com.hiamitchaurasia.example1;

import com.hiamitchaurasia.example1.repository.CommentRepository;
import com.hiamitchaurasia.example1.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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
//        Post post = new Post(1,"Title1","Content1","Author1");
//        Post post1 = new Post(2,"Title2","Content2","Author2");
//        logger.info("Saving Posts and Comments");
//                postRepository.saveAll(Arrays.asList(post,post1));
//                Comment comment1 = new Comment(1,"Comment1","Author1",post);
//                Comment comment2 = new Comment(2,"Comment2","Author2",post1);
//                Comment comment3 = new Comment(3,"Comment3","Author3",post1);
//                commentRepository.saveAll(Arrays.asList(comment1,comment2,comment3));
//        logger.info("Finding all comment objects");
//        List<Comment> comments = commentRepository.findAll();
//        for (Comment comment : comments) {
//            logger.info("Comment [{}] from Post [{}]",comment.getContent(), comment.getPost().getTitle());
//        }

    }

//    @Bean
//    public UserDetailsService users() {
//        // The builder will ensure the passwords are encoded before saving in memory
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//        UserDetails user = users
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//        UserDetails userviewer = users
//                .username("userviewer")
//                .password("password")
//                .roles("VIEWER")
//                .build();
//        UserDetails usereditor = users
//                .username("usereditor")
//                .password("password")
//                .roles("EDITOR")
//                .build();
//        UserDetails admin = users
//                .username("admin")
//                .password("password")
//                .roles("USER", "ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
}