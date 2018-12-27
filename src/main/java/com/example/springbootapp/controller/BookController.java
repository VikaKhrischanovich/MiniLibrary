package com.example.springbootapp.controller;

import com.example.springbootapp.dto.BookDto;
import com.example.springbootapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/createBook")
    public String createBook(@RequestBody final BookDto bookDto) {
        bookService.createBook(bookDto);
        return "Book created";
    }

    @GetMapping("/listBooks")
    public List<BookDto> getAllBooks() {
        return bookService.getBooksList();
    }
}
