package com.academy.spring.services.impl;

import com.academy.spring.dtos.AuthorDto;
import com.academy.spring.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    List<AuthorDto> authors = new ArrayList<>();

    @Override
    public void createAuthor(AuthorDto authorDto) {
        authors.add(authorDto);
    }

    @Override
    public List<AuthorDto> findAuthorList() {
        return authors;
    }
}
