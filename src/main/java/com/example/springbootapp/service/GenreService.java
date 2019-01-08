package com.example.springbootapp.service;

import com.example.springbootapp.converter.GenreConverter;
import com.example.springbootapp.dto.GenreDto;
import com.example.springbootapp.repository.CategoryRepository;
import com.example.springbootapp.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;
    private final GenreConverter genreConverter;
    private final CategoryRepository categoryRepository;

    public String createGenre(final GenreDto genreDto) {
        if (categoryRepository.findByName(genreDto.getCategory()) == null) {
            return "No such category";
        }
        genreRepository.save(genreConverter.convertToDbo(genreDto));
        return "Genre was created";
    }

    public List<GenreDto> getGenresList() {
        return genreRepository.findAll().stream()
                .map(genreConverter::convertToDto).collect(Collectors.toList());
    }


    public List<GenreDto> getGenresByCategory(final String category) {
        return genreRepository.findAllByCategoryName(category).stream()
                .map(genreConverter::convertToDto).collect(Collectors.toList());
    }
}
