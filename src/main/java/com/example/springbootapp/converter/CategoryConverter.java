package com.example.springbootapp.converter;

import com.example.springbootapp.dto.CategoryDto;
import com.example.springbootapp.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryConverter implements DtoDboConverter<CategoryDto, CategoryEntity> {
    private final GenreConverter genreConverter;

    @Override
    public CategoryDto convertToDto(CategoryEntity dbo) {
        final CategoryDto categoryDto = new CategoryDto();
        BeanUtils.copyProperties(dbo, categoryDto);
        categoryDto.setGenres(genreConverter.convertToDto(dbo.getGenres()));
        return categoryDto;
    }

    @Override
    public CategoryEntity convertToDbo(CategoryDto dto) {
        final CategoryEntity categoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(dto, categoryEntity);
        categoryEntity.setGenres(genreConverter.convertToDbo(dto.getGenres()));
        return categoryEntity;
    }
}
