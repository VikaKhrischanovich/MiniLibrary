package com.example.springbootapp.converter;

import com.example.springbootapp.dto.GenreDto;
import com.example.springbootapp.entity.GenreEntity;
import com.example.springbootapp.repository.CategoryRepository;
import com.example.springbootapp.repository.GenreRepository;
import com.example.springbootapp.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GenreConverter implements DtoDboConverter<GenreDto, GenreEntity> {
    private final CategoryRepository categoryRepository;
    private final GenreRepository genreRepository;

    @Override
    public GenreDto convertToDto(final GenreEntity dbo) {
        final GenreDto genreDto = new GenreDto();
        BeanUtils.copyProperties(dbo, genreDto);
        genreDto.setCategory(dbo.getCategory().getName());
        return genreDto;
    }

    @Override
    public GenreEntity convertToDbo(final GenreDto dto) {
        final GenreEntity genreDbo = new GenreEntity();
        BeanUtils.copyProperties(dto, genreDbo);
        genreDbo.setCategory(categoryRepository.findByName(dto.getCategory()));
        return genreDbo;
    }

    public List<String> convertToDto(final List<GenreEntity> genreDbo) {
        final List<String> genreDto = new ArrayList<>();
        genreDbo.forEach(entity -> genreDto.add(entity.getName()));
        return genreDto;
    }

    public List<GenreEntity> convertToDbo(final List<String> genreDto) {
        final List<GenreEntity> genreDbo = new ArrayList<>();
        genreDto.forEach(dto -> genreDbo.add(genreRepository.findByName(dto)));
        return genreDbo;
    }
}
