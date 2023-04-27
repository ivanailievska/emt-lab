package com.example.bookrental.service;


import com.example.bookrental.model.dto.AuthorDto;
import com.example.bookrental.model.entity.Author;

import java.util.List;

public interface IAuthorService {
    Author addAuthor(AuthorDto authorDto);
    List<Author> getAllAuthors();
    Author getAuthorById(Long id);
    void deleteAuthor(Long id);
    Author editAuthor(Long id, AuthorDto author);
}