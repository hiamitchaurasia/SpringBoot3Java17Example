package com.hiamitchaurasia.example1.repository;

import com.hiamitchaurasia.example1.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAll();

}

