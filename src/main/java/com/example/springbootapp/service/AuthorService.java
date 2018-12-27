package com.example.springbootapp.service;

import com.example.springbootapp.converter.AuthorConverter;
import com.example.springbootapp.dto.AuthorDto;
import com.example.springbootapp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorConverter authorConverter;

    @Autowired
    public AuthorService(final AuthorRepository authorRepository, final AuthorConverter authorConverter) {
        this.authorRepository = authorRepository;
        this.authorConverter = authorConverter;
    }

    public void createAuthor(final AuthorDto authorDto) {
        authorRepository.save(authorConverter.convertToDbo(authorDto));
    }

    public List<AuthorDto> getAuthorsList() {
        return authorRepository.findAll().stream().map(authorConverter::convertToDto).collect(Collectors.toList());
    }
}
