package com.example.springbootapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
    private List<String> genres;
}
