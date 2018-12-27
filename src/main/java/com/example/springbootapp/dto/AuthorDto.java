package com.example.springbootapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorDto {
    private Long id;
    private String firstName;
    private String lastName;
}
