package com.example.springbootapp.controller;

import com.example.springbootapp.dto.CategoryDto;
import com.example.springbootapp.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/listCategories")
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/createCategory")
    public String createCategory(@RequestBody final String category) {
        return categoryService.createCategory(category);
    }
}
