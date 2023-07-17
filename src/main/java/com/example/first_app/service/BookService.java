package com.example.first_app.service;

import com.example.first_app.model.Book;
import com.example.first_app.repositry.BookRespository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookServiceInter{
    private final BookRespository bookRespositry;

    public BookService(BookRespository bookRespositry)
    {
        this.bookRespositry = bookRespositry;
    }

    public List<Book> getAllBooks(){
        List<Book> books = new ArrayList<Book>();  //change variable name
        bookRespositry.findAll().forEach(book -> books.add(book));
        return books;
    }

    public Book getBookByID(int id){
        return bookRespositry.findById(id).orElse(null);
    }

    public Integer createBook(Book book){
        bookRespositry.save(book);
        return book.getId();
    }

    public String deleteById(int id){
        if(bookRespositry.findById(id).isPresent()){
            bookRespositry.deleteById(id);
            return id+" is deleted";
        }
        return id+" not found in the database.";
    }//do error handling

    public String updateBook(int id, String bookName, Optional<Integer> ttl, Optional<Timestamp> expiryTime) {
        if(bookRespositry.existsById(id)){
            Book book = bookRespositry.findById(id).get();
            if(bookName!=null){
                book.setBookName(bookName);
            }
            if(ttl.isPresent()){
                book.setTtl(ttl.get());
            }
            if(expiryTime.isPresent()){
                book.setExpiryTime(expiryTime.get());
            }
            bookRespositry.save(book);
            return "Entities are updated";
        }
        return "User Id doesn't exist";
    }
}
