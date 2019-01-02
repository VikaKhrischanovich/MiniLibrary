package com.example.springbootapp.service;

import com.example.springbootapp.converter.BookConverter;
import com.example.springbootapp.dto.BookDto;
import com.example.springbootapp.entity.BookEntity;
import com.example.springbootapp.entity.CategoryEntity;
import com.example.springbootapp.entity.GenreEntity;
import com.example.springbootapp.repository.BookRepository;
import com.example.springbootapp.repository.CategoryRepository;
import com.example.springbootapp.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookConverter bookConverter;
    private final GenreRepository genreRepository;
    private final CategoryRepository categoryRepository;

    public String createBook(final BookDto bookDto) {
        final boolean[] exists = {true};
        bookDto.getGenres().forEach(genre -> {
            if (genreRepository.findByName(genre) == null) {
                exists[0] = false;
            }
        });
        if(exists[0]) {
            bookRepository.save(bookConverter.convertToDbo(bookDto));
            return "Book was created";
        }
        return "No such genre";
    }

    public List<BookDto> getBooksList(final String[] genres) {
        if (genres.length != 0) {
            List<BookEntity> selected = genreRepository.findByName(genres[0]).getBooks();
            for (int i = 1; i < genres.length; i++) {
                final GenreEntity genre = genreRepository.findByName(genres[i]);
                final List<BookEntity> afterDelete = new ArrayList<>(selected);
                selected.forEach(bookEntity -> {
                    if (!bookEntity.getGenres().contains(genre)) {
                        afterDelete.remove(bookEntity);
                    }
                });
                selected = new ArrayList<>(afterDelete);
            }
            return selected.stream().map(bookConverter::convertToDto).collect(Collectors.toList());
        }

        return bookRepository.findAll().stream()
                .map(bookConverter::convertToDto).collect(Collectors.toList());
    }

    public List<BookDto> getBooksListByCategory(final String category) {
        final CategoryEntity categoryEntity = categoryRepository.findByName(category);
        final List<GenreEntity> genreEntities = categoryEntity.getGenres();
        final Set<BookEntity> selected = new HashSet<>();
        genreEntities.forEach(genre -> selected.addAll(genre.getBooks()));
        return selected.stream()
                .map(bookConverter::convertToDto).collect(Collectors.toList());
    }
}
