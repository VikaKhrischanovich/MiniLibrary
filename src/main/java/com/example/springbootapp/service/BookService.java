package com.example.springbootapp.service;

import com.example.springbootapp.converter.AuthorConverter;
import com.example.springbootapp.converter.BookConverter;
import com.example.springbootapp.dto.AuthorDto;
import com.example.springbootapp.dto.BookDto;
import com.example.springbootapp.entity.AuthorEntity;
import com.example.springbootapp.entity.BookEntity;
import com.example.springbootapp.enumeration.SORT_TYPE;
import com.example.springbootapp.repository.AuthorRepository;
import com.example.springbootapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookConverter bookConverter;
    private final AuthorRepository authorRepository;
    private final AuthorConverter authorConverter;
    private final Map<SORT_TYPE, Sort> sortMap;

    @Autowired
    public BookService(final BookRepository bookRepository, final BookConverter bookConverter,
                       final AuthorRepository authorRepository, final AuthorConverter authorConverter,
                       final Map<SORT_TYPE, Sort> sortMap) {
        this.bookRepository = bookRepository;
        this.bookConverter = bookConverter;
        this.authorRepository = authorRepository;
        this.authorConverter = authorConverter;
        this.sortMap = sortMap;
    }

    @Transactional
    public void createBook(final BookDto bookDto) {
        final List<AuthorEntity> toSaveAuthorEntities = new ArrayList<>();
        bookDto.getAuthors().forEach(authorDto -> {
            final String firstName = authorDto.getFirstName();
            final String lastName = authorDto.getLastName();
            final AuthorEntity existingAuthor =
                    authorRepository.findByFirstNameAndLastName(firstName, lastName);
            if (existingAuthor == null) {
                final AuthorEntity newAuthor = authorConverter.convertToEntity(authorDto);
                toSaveAuthorEntities.add(newAuthor);
            } else {
                toSaveAuthorEntities.add(existingAuthor);
            }
        });

        final BookEntity bookEntity = bookConverter.convertToEntity(bookDto);
        bookEntity.setAuthors(toSaveAuthorEntities);
        bookRepository.save(bookEntity);
        authorRepository.saveAll(toSaveAuthorEntities);
    }

    public List<BookDto> getBookByName(String name) {
        final List<BookEntity> bookEntity = bookRepository.findByNameContaining(name);
        return convertList(bookEntity);
    }

    public List<BookDto> getBooksList() {
        final List<BookEntity> bookEntities = bookRepository.findAll();
        return convertList(bookEntities);
    }

    public List<BookDto> getBooksList(SORT_TYPE sortType) {
        final Sort sort = sortMap.get(sortType);
        final List<BookEntity> bookEntities = bookRepository.findAll(sort);
        return convertList(bookEntities);
    }

    private List<BookDto> convertList(List<BookEntity> bookEntities) {
        final List<BookDto> bookDtos = new ArrayList<>();
        bookEntities.forEach(bookEntity -> bookDtos.add(convert(bookEntity)));
        return bookDtos;
    }

    private BookDto convert(final BookEntity bookEntity) {
        final BookDto bookDto = bookConverter.convertToDto(bookEntity);
        final List<AuthorDto> authorDtos = new ArrayList<>();
        bookEntity.getAuthors().forEach(authorEntity -> authorDtos.add(authorConverter.convertToDto(authorEntity)));
        bookDto.setAuthors(authorDtos);
        return bookDto;
    }
}
