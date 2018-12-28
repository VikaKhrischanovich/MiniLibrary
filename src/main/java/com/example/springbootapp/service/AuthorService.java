package com.example.springbootapp.service;

import com.example.springbootapp.converter.AuthorConverter;
import com.example.springbootapp.converter.BookConverter;
import com.example.springbootapp.dto.AuthorDto;
import com.example.springbootapp.dto.BookDto;
import com.example.springbootapp.entity.AuthorEntity;
import com.example.springbootapp.enumeration.SORT_TYPE;
import com.example.springbootapp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorConverter authorConverter;
    private final BookConverter bookConverter;
    private final Map<SORT_TYPE, Sort> sortMap;

    @Autowired
    public AuthorService(final AuthorRepository authorRepository, final AuthorConverter authorConverter,
                         final BookConverter bookConverter, final Map<SORT_TYPE, Sort> sortMap) {
        this.authorRepository = authorRepository;
        this.authorConverter = authorConverter;
        this.bookConverter = bookConverter;
        this.sortMap = sortMap;
    }

    public void createAuthor(final AuthorDto authorDto) {
        authorRepository.save(authorConverter.convertToEntity(authorDto));
    }

    public List<AuthorDto> getAuthorByLastName(String lastName) {
        final List<AuthorEntity> authorEntity = authorRepository.findByLastName(lastName);
        return convertList(authorEntity);
    }

    public List<AuthorDto> getAuthorsList() {
        final List<AuthorEntity> authorEntities = authorRepository.findAll();
        return convertList(authorEntities);
    }

    public List<AuthorDto> getAuthorsList(final SORT_TYPE sortType) {
        final Sort sort = sortMap.get(sortType);
        final List<AuthorEntity> authorEntities = authorRepository.findAll(sort);
        return convertList(authorEntities);
    }

    private List<AuthorDto> convertList(final List<AuthorEntity> authorEntities) {
        final List<AuthorDto> authorDtos = new ArrayList<>();
        authorEntities.forEach(authorEntity -> authorDtos.add(convert(authorEntity)));
        return authorDtos;
    }

    private AuthorDto convert(final AuthorEntity authorEntity) {
        final AuthorDto authorDto = authorConverter.convertToDto(authorEntity);
        final List<BookDto> bookDtos = new ArrayList<>();
        authorEntity.getBooks().forEach(bookEntity -> bookDtos.add(bookConverter.convertToDto(bookEntity)));
        authorDto.setBooks(bookDtos);
        return authorDto;
    }
}
