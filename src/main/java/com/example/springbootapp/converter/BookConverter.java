package com.example.springbootapp.converter;

import com.example.springbootapp.dto.BookDto;
import com.example.springbootapp.entity.BookEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookConverter implements DtoDboConverter<BookDto, BookEntity> {
    private final GenreConverter genreConverter;

    @Override
    public BookDto convertToDto(final BookEntity dbo) {
        final BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(dbo, bookDto);
        bookDto.setGenres(genreConverter.convertToDto(dbo.getGenres()));
        return bookDto;
    }

    @Override
    public BookEntity convertToDbo(final BookDto dto) {
        final BookEntity bookDbo = new BookEntity();
        BeanUtils.copyProperties(dto, bookDbo);
        bookDbo.setGenres(genreConverter.convertToDbo(dto.getGenres()));
        return bookDbo;
    }
}
