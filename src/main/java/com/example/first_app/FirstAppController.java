package com.example.first_app;
import com.example.first_app.model.Books;
import com.example.first_app.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class FirstAppController {
    @Autowired
    private BookService bookService;

//    FirstAppController(BookService bookService){
//        this.bookService = bookService;
//    }
//    BookService bookService = new BookService();

    @GetMapping("/hello")
    public String test(){
        return "Welcome to this app..!!";
    }

    @GetMapping("/getAll")
    public List<Books> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/get/{bookId}")
    public Books getBookById(@PathVariable("bookId") int id){
        return bookService.getBookByID(id);
    }

    @PostMapping("/enter")
    public void createBook(@RequestBody Books books){
        bookService.createBook(books);
    }

    @DeleteMapping("/delete/{bookId}")
    public void deleteById(@PathVariable("bookId") int id){
        bookService.deleteById(id);
    }

    @PutMapping("/update/{bookId}")
    public Books updateBook(@RequestBody Books books,@PathVariable("bookId") int id){
        return bookService.updateBook(books, id);
    }
}
