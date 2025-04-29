package com.academy.spring.repository;

import com.academy.spring.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    public List<Author> findByNameLikeIgnoreCase(String name);
}
