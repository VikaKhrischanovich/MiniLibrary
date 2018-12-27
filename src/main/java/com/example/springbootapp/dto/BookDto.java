package com.example.springbootapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String name;
    private Long authorId;
    private String feedback;
    private Double rating;
    private String description;
    private int year;
}
