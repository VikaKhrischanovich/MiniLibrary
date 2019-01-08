package com.example.springbootapp.controller;

import com.example.springbootapp.dto.BookDto;
import com.example.springbootapp.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/createBook")
    public String createBook(@RequestBody final BookDto bookDto) {
        return bookService.createBook(bookDto);
    }

    @GetMapping("/listBooks")
    public List<BookDto> getAllBooks(final HttpServletRequest request) {
        final String[] genres = request.getParameterValues("genre");
        return bookService.getBooksList(genres);
    }

    @GetMapping("/listBooksByCategory/{category}")
    public List<BookDto> getBooksByCategory(@PathVariable("category") final String category) {
        return bookService.getBooksListByCategory(category);
    }
}
