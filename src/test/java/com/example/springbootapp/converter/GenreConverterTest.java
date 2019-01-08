package com.example.springbootapp.converter;

import com.example.springbootapp.MockDataGenre;
import com.example.springbootapp.dto.GenreDto;
import com.example.springbootapp.entity.GenreEntity;
import com.example.springbootapp.repository.CategoryRepository;
import com.example.springbootapp.repository.GenreRepository;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.*;

public class GenreConverterTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private GenreRepository genreRepository;

    private final GenreConverter genreConverter = new GenreConverter(categoryRepository, genreRepository);

    @Test
    public void convertToDto(){
        final GenreEntity genreEntity = MockDataGenre.genreEntity();
        final GenreDto genreDto = genreConverter.convertToDto(genreEntity);
        assertEquals(genreEntity.getName(), genreDto.getName());
    }

    @Test
    public void convertToDbo(){
        final GenreDto genreDto = MockDataGenre.genreDto();
        final GenreEntity genreEntity = genreConverter.convertToDbo(genreDto);
        assertEquals(genreDto.getName(), genreEntity.getName());
    }

}
