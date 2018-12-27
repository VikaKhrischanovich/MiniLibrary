package com.example.springbootapp;

import com.example.springbootapp.dto.AuthorDto;
import com.example.springbootapp.entity.AuthorEntity;

public class MockDataAuthor {

    public static AuthorEntity authorEntity(){
        final AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setFirstName("authorEntity first name");
        authorEntity.setLastName("authorEntity last name");
        return authorEntity;
    }

    public static AuthorDto authorDto(){
        final AuthorDto authorDto = new AuthorDto();
        authorDto.setFirstName("authorDto first name");
        authorDto.setLastName("authorDto last name");
        return authorDto;
    }
}
