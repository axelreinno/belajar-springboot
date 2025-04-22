package com.academy.spring.services;

import com.academy.spring.dtos.AuthorDto;

import java.util.List;

public interface AuthorService {
    public void createAuthor(AuthorDto authorDto);
    public List<AuthorDto> findAuthorList();
}
