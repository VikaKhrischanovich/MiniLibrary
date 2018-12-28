package com.example.springbootapp.controller;

import com.example.springbootapp.dto.AuthorDto;
import com.example.springbootapp.enumeration.SORT_TYPE;
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
    public List<AuthorDto> getAllAuthors(final @RequestParam(name = "sortType", required = false) String sortTypeParam) {
        if (sortTypeParam == null) {
            return authorService.getAuthorsList();
        } else {
            SORT_TYPE sortType = SORT_TYPE.valueOf(sortTypeParam.toUpperCase());
            return authorService.getAuthorsList(sortType);
        }
    }

    @GetMapping("/byLastName")
    public List<AuthorDto> getAuthorByLastName(final @RequestParam String lastName) {
        return authorService.getAuthorByLastName(lastName);
    }
}
