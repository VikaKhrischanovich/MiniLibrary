package com.example.springbootapp.converter;

import com.example.springbootapp.dto.BookDto;
import com.example.springbootapp.entity.BookEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BookConverter implements DtoDboConverter<BookDto, BookEntity> {
    @Override
    public BookDto convertToDto(final BookEntity dbo) {
        final BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(dbo, bookDto);
        return bookDto;
    }

    @Override
    public BookEntity convertToDbo(final BookDto dto) {
        final BookEntity bookDbo = new BookEntity();
        BeanUtils.copyProperties(dto, bookDbo);
        return bookDbo;
    }
}
