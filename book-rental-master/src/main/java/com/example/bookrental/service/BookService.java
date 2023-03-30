package com.example.bookrental.service;

import com.example.bookrental.model.dto.BookDto;
import com.example.bookrental.model.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    void deleteBook(Long id);
    Book editBook(Long id, BookDto book);
    void markBookAsTaken(Long id);
    Book addBook(BookDto book);
}
