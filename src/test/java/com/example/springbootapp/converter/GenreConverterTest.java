package com.example.springbootapp.converter;

import com.example.springbootapp.MockDataGenre;
import com.example.springbootapp.dto.GenreDto;
import com.example.springbootapp.entity.GenreEntity;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenreConverterTest {

    private final GenreConverter genreConverter = new GenreConverter();

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
