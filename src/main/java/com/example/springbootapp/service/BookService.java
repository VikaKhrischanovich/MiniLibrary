package com.example.springbootapp.service;

import com.example.springbootapp.converter.BookConverter;
import com.example.springbootapp.dto.BookDto;
import com.example.springbootapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookConverter bookConverter;

    @Autowired
    public BookService(final BookRepository bookRepository, final BookConverter bookConverter) {
        this.bookRepository = bookRepository;
        this.bookConverter = bookConverter;
    }

    public void createBook(final BookDto bookDto) {
        bookRepository.save(bookConverter.convertToDbo(bookDto));
    }

    public List<BookDto> getBooksList() {
        return bookRepository.findAll().stream().map(bookConverter::convertToDto).collect(Collectors.toList());
    }
}
