package com.example.springbootapp.converter;

import com.example.springbootapp.dto.AuthorDto;
import com.example.springbootapp.entity.AuthorEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthorConverter implements DtoEntityConverter<AuthorDto, AuthorEntity> {
    @Override
    public AuthorDto convertToDto(final AuthorEntity dbo) {
        final AuthorDto authorDto = new AuthorDto();
        BeanUtils.copyProperties(dbo, authorDto, "books");
        return authorDto;
    }

    @Override
    public AuthorEntity convertToEntity(final AuthorDto dto) {
        final AuthorEntity authorEntity = new AuthorEntity();
        BeanUtils.copyProperties(dto, authorEntity,"books");
        return authorEntity;
    }
}
