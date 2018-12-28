package com.example.springbootapp.service;

import com.example.springbootapp.converter.GenreConverter;
import com.example.springbootapp.dto.GenreDto;
import com.example.springbootapp.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {
    private final GenreRepository genreRepository;
    private final GenreConverter genreConverter;

    @Autowired
    public GenreService(final GenreRepository genreRepository, final GenreConverter genreConverter) {
        this.genreRepository = genreRepository;
        this.genreConverter = genreConverter;
    }

    public void createGenre(final GenreDto genreDto) {
        genreRepository.save(genreConverter.convertToEntity(genreDto));
    }

    public List<GenreDto> getGenresList() {
        return genreRepository.findAll().stream().map(genreConverter::convertToDto).collect(Collectors.toList());
    }
}
