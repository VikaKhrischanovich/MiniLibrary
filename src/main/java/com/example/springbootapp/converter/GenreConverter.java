package com.example.springbootapp.converter;

import com.example.springbootapp.dto.GenreDto;
import com.example.springbootapp.entity.GenreEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class GenreConverter implements DtoEntityConverter<GenreDto, GenreEntity> {
    @Override
    public GenreDto convertToDto(final GenreEntity dbo) {
        final GenreDto genreDto = new GenreDto();
        BeanUtils.copyProperties(dbo, genreDto);
        return genreDto;
    }

    @Override
    public GenreEntity convertToEntity(final GenreDto dto) {
        final GenreEntity genreDbo = new GenreEntity();
        BeanUtils.copyProperties(dto, genreDbo);
        return genreDbo;
    }
}
