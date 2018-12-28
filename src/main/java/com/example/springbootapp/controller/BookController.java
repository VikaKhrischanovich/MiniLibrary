package com.example.springbootapp.controller;

import com.example.springbootapp.dto.BookDto;
import com.example.springbootapp.enumeration.SORT_TYPE;
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
    public List<BookDto> getAllBooks(final @RequestParam(name = "sortType", required = false) String sortTypeParam) {
        if (sortTypeParam == null) {
            return bookService.getBooksList();
        } else {
            SORT_TYPE sortType = SORT_TYPE.valueOf(sortTypeParam.toUpperCase());
            return bookService.getBooksList(sortType);
        }
    }

    @GetMapping("/byName")
    public List<BookDto> getBookByName(final @RequestParam String name) {
        return bookService.getBookByName(name);
    }
}
