package com.hiamitchaurasia.app1.repository;
import com.hiamitchaurasia.app1.model.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BookRepository extends ReactiveCrudRepository<Book, Long> {
}
