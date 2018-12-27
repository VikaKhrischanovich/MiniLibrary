package com.example.springbootapp;

import com.example.springbootapp.dto.BookDto;
import com.example.springbootapp.entity.BookEntity;

public class MockDataBook {

    public static BookEntity bookEntity(){
        final BookEntity bookEntity = new BookEntity();
        bookEntity.setName("bookEntity name");
//        bookEntity.setAuthorId("bookEntity authorId");
//        bookEntity.setFeedback("bookEntity feedback");
//        bookEntity.setRating("bookEntity rating");
//        bookEntity.setDescription("bookEntity description");
//        bookEntity.setYear("bookEntity year");
        return bookEntity;
    }

    public static BookDto bookDto(){
        final BookDto bookDto = new BookDto();
        bookDto.setName("bookDto name");
//        bookDto.setAuthorId("bookDto authorId");
//        bookDto.setFeedback("bookDto feedback");
//        bookDto.setRating("bookDto rating");
//        bookDto.setDescription("bookDto description");
//        bookDto.setYear("bookDto year");
        return bookDto;
    }

}
