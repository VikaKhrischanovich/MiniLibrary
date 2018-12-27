package com.example.springbootapp.controller;

import com.example.springbootapp.dto.AuthorDto;
import com.example.springbootapp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(final AuthorService authorService) {
        this.authorService = authorService;
    }

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
