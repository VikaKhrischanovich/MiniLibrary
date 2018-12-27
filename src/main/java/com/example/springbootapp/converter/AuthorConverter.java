package com.example.springbootapp.converter;

import com.example.springbootapp.dto.AuthorDto;
import com.example.springbootapp.entity.AuthorEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthorConverter implements DtoDboConverter <AuthorDto, AuthorEntity>{
    @Override
    public AuthorDto convertToDto(final AuthorEntity dbo) {
        final AuthorDto authorDto = new AuthorDto();
        BeanUtils.copyProperties(dbo, authorDto);
        return authorDto;
    }

    @Override
    public AuthorEntity convertToDbo(final AuthorDto dto) {
        final AuthorEntity authorDbo = new AuthorEntity();
        BeanUtils.copyProperties(dto, authorDbo);
        return authorDbo;
    }
}
