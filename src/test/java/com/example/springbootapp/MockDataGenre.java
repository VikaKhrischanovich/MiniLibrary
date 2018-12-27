package com.example.springbootapp;

import com.example.springbootapp.dto.GenreDto;
import com.example.springbootapp.entity.GenreEntity;

public class MockDataGenre {

    public static GenreEntity genreEntity(){
        final GenreEntity genreEntity = new GenreEntity();
        genreEntity.setName("genreEntity name");
        return genreEntity;
    }

    public static GenreDto genreDto(){
        final GenreDto genreDto = new GenreDto();
        genreDto.setName("genreDto name");
        return genreDto;
    }

}
