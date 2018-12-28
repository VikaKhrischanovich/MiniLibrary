package com.example.springbootapp.converter;

import com.example.springbootapp.dto.BookDto;
import com.example.springbootapp.entity.BookEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BookConverter implements DtoEntityConverter<BookDto, BookEntity> {
    @Override
    public BookDto convertToDto(final BookEntity entity) {
        final BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(entity, bookDto,"authors");
        return bookDto;
    }

    @Override
    public BookEntity convertToEntity(final BookDto dto) {
        final BookEntity bookEntity = new BookEntity();
        BeanUtils.copyProperties(dto, bookEntity,"authors");
        return bookEntity;
    }
}
