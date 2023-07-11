package com.example.first_app.service;

import com.example.first_app.model.Books;

import java.util.List;

public interface BookServiceInter {
    public List<Books> getAllBooks();
    public Books getBookByID(int id);
    public void createBook(Books books);
    public void deleteById(int id);
    public Books updateBook(Books books, int id);
}
