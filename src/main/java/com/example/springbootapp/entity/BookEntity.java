package com.example.springbootapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "BOOK")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Long authorId;

    @NotNull
    private String feedback;

    @NotNull
    private Double rating;

    @NotNull
    private String description;

    @NotNull
    private int year;
}
