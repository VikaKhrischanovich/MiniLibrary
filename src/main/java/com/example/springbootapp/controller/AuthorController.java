package com.example.springbootapp.controller;

import com.example.springbootapp.dto.AuthorDto;
import com.example.springbootapp.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("/createAuthor")
    public String createAuthor(@RequestBody final AuthorDto authorDto) {
        authorService.createAuthor(authorDto);
        return "Author created";
    }

    @GetMapping("/listAuthors")
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAuthorsList();
    }
}
