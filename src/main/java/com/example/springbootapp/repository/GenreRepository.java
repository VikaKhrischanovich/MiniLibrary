package com.example.springbootapp.repository;

import com.example.springbootapp.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
    List<GenreEntity> findAllByCategoryName(String name);
    GenreEntity findByName(String name);
}
