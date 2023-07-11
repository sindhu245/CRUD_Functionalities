package com.example.first_app.service;

import com.example.first_app.model.Books;
import com.example.first_app.repositry.BookRespository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements BookServiceInter{
    private final BookRespository bookRespositry;

    BookService(BookRespository bookRespositry)
    {
        this.bookRespositry = bookRespositry;
    }

    public List<Books> getAllBooks(){
        List<Books> books1 = new ArrayList<Books>();
        bookRespositry.findAll().forEach(books -> books1.add(books));
        return books1;
    }

    public Books getBookByID(int id){
        return bookRespositry.findById(id).orElse(null);
    }

    public void createBook(Books books){
        bookRespositry.save(books);
    }

    public void deleteById(int id){
        bookRespositry.deleteById(id);
    }

    public Books updateBook(Books books, int id){
        Books book = bookRespositry.findById(id).get();
        book.setBookName(books.getBookName());
        book.setCost(books.getCost());
        return bookRespositry.save(book);
    }

}
