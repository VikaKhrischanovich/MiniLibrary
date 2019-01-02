package com.example.springbootapp.controller;

import com.example.springbootapp.dto.GenreDto;
import com.example.springbootapp.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
@AllArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @PostMapping("/createGenre")
    public String createGenre(@RequestBody final GenreDto genreDto) {
        return genreService.createGenre(genreDto);
    }

    @GetMapping("/listGenres")
    public List<GenreDto> getAllGenres() {
        return genreService.getGenresList();
    }

    @GetMapping("/listGenres/{category}")
    public List<GenreDto> getByCategory(@PathVariable("category") final String category) {
        return genreService.getGenresByCategory(category);
    }
}
