package com.example.bookrental.dataInit;

import com.example.bookrental.model.entity.Author;
import com.example.bookrental.model.entity.Book;
import com.example.bookrental.model.entity.Country;
import com.example.bookrental.model.enums.BookCategory;
import com.example.bookrental.repository.AuthorRepository;
import com.example.bookrental.repository.BookRepository;
import com.example.bookrental.repository.CountryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInit {
    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataInit(CountryRepository countryRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init() {
        if (countryRepository.count() != 0 || authorRepository.count() != 0 || bookRepository.count() != 0) {
            return;
        }
        for (int i = 1; i < 10; i++) {
            createFake(i);
        }
    }

    private void createFake(int i) {
        Country country = new Country();
        country.setName(String.format("Country %d", i));
        country.setContinent(String.format("Continent %d", i));
        countryRepository.save(country);

        Author author = new Author();
        author.setName(String.format("Name %d", i));
        author.setSurname(String.format("Surname %d", i));
        author.setCountry(country);
        authorRepository.save(author);

        Book book = new Book();
        book.setName(String.format("Name %d", i));
        book.setCategory(BookCategory.values()[i % BookCategory.values().length]);
        book.setAuthor(author);
        book.setAvailableCopies(i);
        bookRepository.save(book);
    }
}
