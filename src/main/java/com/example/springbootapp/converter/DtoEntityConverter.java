package com.example.springbootapp.converter;

public interface DtoEntityConverter<T, B> {
    T convertToDto(final B entity);
    B convertToEntity(final T dto);
}

