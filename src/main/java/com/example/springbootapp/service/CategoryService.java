package com.example.springbootapp.service;

import com.example.springbootapp.converter.CategoryConverter;
import com.example.springbootapp.dto.CategoryDto;
import com.example.springbootapp.entity.CategoryEntity;
import com.example.springbootapp.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    public String createCategory(String category) {
        if(categoryRepository.findByName(category) != null) {
            return "Category already exists";
        }

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(category);
        categoryRepository.save(categoryEntity);
        return "Category was created";
    }

    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryConverter::convertToDto).collect(Collectors.toList());
    }
}
