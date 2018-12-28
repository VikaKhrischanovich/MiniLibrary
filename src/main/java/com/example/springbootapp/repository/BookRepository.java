package com.example.springbootapp.repository;

import com.example.springbootapp.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findByNameContaining(String name);
}
