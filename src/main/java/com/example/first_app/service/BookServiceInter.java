package com.example.first_app.service;

import com.example.first_app.model.Book;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface BookServiceInter {
    public List<Book> getAllBooks();
    public Book getBookByID(int id);
    public Integer createBook(Book books);
    public String deleteById(int id);
    public String updateBook(int id, String bookName,  Optional<Integer> ttl, Optional<Timestamp> expiryTime);
}
