package com.example.bookrental.controller;

import com.example.bookrental.model.dto.BookDto;
import com.example.bookrental.model.entity.Book;
import com.example.bookrental.service.IBookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/books")
public class BookController {

    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/all/page/{page}")
    public List<Book> getAllBooksByPage(@PathVariable int page) {
        return bookService.getAllBooksByPage(Pageable.ofSize(5).withPage(page));
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody BookDto book) {
        Book newBook = bookService.addBook(book);

        if (newBook == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(newBook);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Book book = bookService.getBookById(id);

        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            bookService.deleteBook(id);
            return ResponseEntity.ok(book);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody BookDto book) {
        Book newBook = bookService.editBook(id, book);
        if (newBook == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(newBook);
        }
    }

    @PutMapping("/mark/{id}")
    public ResponseEntity<Book> markBookAsTaken(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            bookService.markBookAsTaken(id);
            return ResponseEntity.ok(book);
        }
    }
}