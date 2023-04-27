package com.example.bookrental.model.dto;

import com.example.bookrental.model.enums.BookCategory;
import lombok.Data;

@Data
public class BookDto {
    private String name;
    private Long author;
    private BookCategory category;
    private Integer availableCopies;
}
