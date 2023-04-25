package com.hiamitchaurasia.example1.repository;

import com.hiamitchaurasia.example1.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
