package com.example.first_app.controller;
import com.example.first_app.model.Book;
import com.example.first_app.service.BookServiceInter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class FirstAppController {
    @Autowired
    private BookServiceInter bookService;

//    FirstAppController(BookService bookService){
//        this.bookService = bookService;
//    }
//    BookService bookService = new BookService();

    @GetMapping("/getAll")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/get/{bookId}")
    public Book getBookById(@PathVariable("bookId") int id){
        return bookService.getBookByID(id);
    }

    @PostMapping("/enter")
    public Integer createBook(@RequestBody Book books){  //never create a void return
        return bookService.createBook(books);
    }

    @DeleteMapping("/delete/{bookId}")
    public String deleteById(@PathVariable("bookId") int id){
        return bookService.deleteById(id);
    }

//    @PutMapping("/update/{bookId}")
//    public Book updateBook(@RequestBody Book books, @PathVariable("bookId") int id){ //id first
//        return bookService.updateBook(books, id);
//    }

    @PutMapping("/update/{bookId}")
    public String updateBook(@PathVariable("bookId") int id, @RequestParam(value = "bookName",required = false) String bookName, @RequestParam("ttl") Optional<Integer> ttl, @RequestParam("expiryTime")Optional<Timestamp> expiryTime){ //id first
        return bookService.updateBook(id, bookName, ttl, expiryTime);
    }

}
