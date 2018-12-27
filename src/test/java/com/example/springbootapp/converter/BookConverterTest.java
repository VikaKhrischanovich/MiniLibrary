package com.example.springbootapp.converter;

import com.example.springbootapp.MockDataBook;
import com.example.springbootapp.dto.BookDto;
import com.example.springbootapp.entity.BookEntity;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookConverterTest {

    private final BookConverter bookConverter = new BookConverter();

    @Test
    public void convertToDto(){
        final BookEntity bookEntity = MockDataBook.bookEntity();
        final BookDto bookDto = bookConverter.convertToDto(bookEntity);
        assertEquals(bookEntity.getName(), bookDto.getName());
        assertEquals(bookEntity.getAuthorId(), bookDto.getAuthorId());
        assertEquals(bookEntity.getFeedback(), bookDto.getFeedback());
        assertEquals(bookEntity.getRating(), bookDto.getRating());
        assertEquals(bookEntity.getDescription(), bookDto.getDescription());
        assertEquals(bookEntity.getYear(), bookDto.getYear());
    }

    @Test
    public void convertToDbo(){
        final BookDto bookDto = MockDataBook.bookDto();
        final BookEntity bookEntity = bookConverter.convertToDbo(bookDto);
        assertEquals(bookDto.getName(), bookEntity.getName());
        assertEquals(bookDto.getAuthorId(), bookEntity.getAuthorId());
        assertEquals(bookDto.getFeedback(), bookEntity.getFeedback());
        assertEquals(bookDto.getRating(), bookEntity.getRating());
        assertEquals(bookDto.getDescription(), bookEntity.getDescription());
        assertEquals(bookDto.getYear(), bookEntity.getYear());
    }

}
