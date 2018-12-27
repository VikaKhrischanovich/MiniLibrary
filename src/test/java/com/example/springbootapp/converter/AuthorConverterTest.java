package com.example.springbootapp.converter;

import com.example.springbootapp.MockDataAuthor;
import com.example.springbootapp.dto.AuthorDto;
import com.example.springbootapp.entity.AuthorEntity;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorConverterTest {

    private final AuthorConverter authorConverter = new AuthorConverter();

    @Test
    public void convertToDto(){
        final AuthorEntity authorEntity = MockDataAuthor.authorEntity();
        final AuthorDto authorDto = authorConverter.convertToDto(authorEntity);
        assertEquals(authorEntity.getFirstName(), authorDto.getFirstName());
        assertEquals(authorEntity.getLastName(), authorDto.getLastName());
    }

    @Test
    public void convertToDbo(){
        final AuthorDto authorDto = MockDataAuthor.authorDto();
        final AuthorEntity authorEntity = authorConverter.convertToDbo(authorDto);
        assertEquals(authorDto.getFirstName(), authorEntity.getFirstName());
        assertEquals(authorDto.getLastName(), authorEntity.getLastName());
    }
}
