package com.academy.spring.services.impl;

import com.academy.spring.domain.Author;
import com.academy.spring.dtos.AuthorDto;
import com.academy.spring.repository.AuthorRepository;
import com.academy.spring.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void createAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setName(authorDto.name());
        author.setDescription(authorDto.description());
        authorRepository.save(author);
    }

    @Override
    public List<AuthorDto> findAuthorList() {
        return authorRepository
                .findAll()
                .stream()
                .map(author -> new AuthorDto(author.getName(), author.getDescription()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthorDto> findAuthorListByName(String name) {

        List<Author> authorList = authorRepository.findByNameLikeIgnoreCase(name);

        return authorList
                .stream()
                .map(author -> new AuthorDto(author.getName(), author.getDescription()))
                .collect(Collectors.toList());
    }


}
