package com.example.springbootapp.repository;

import com.example.springbootapp.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    AuthorEntity findByFirstNameAndLastName(String firstName, String lastName);
    List<AuthorEntity> findByLastName(String lastName);
}
