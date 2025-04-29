package com.academy.spring.repository;

import com.academy.spring.domain.Author;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorRepositoryTests {

    @Inject
    AuthorRepository authorRepository;

    @Test
    void testSaveAuthor() {
        Author author = new Author();
        author.setName("Axel Reinno");
        author.setDescription("Description");
        authorRepository.save(author);
    }
}
