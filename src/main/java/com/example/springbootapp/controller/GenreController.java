package com.example.springbootapp.controller;

import com.example.springbootapp.dto.GenreDto;
import com.example.springbootapp.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {
    private final GenreService genreService;

    @Autowired
    public GenreController(final GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping("/createGenre")
    public String createGenre(@RequestBody final GenreDto genreDto) {
        genreService.createGenre(genreDto);
        return "Genre created";
    }

    @GetMapping("/listGenres")
    public List<GenreDto> getAllGenres() {
        return genreService.getGenresList();
    }
}
