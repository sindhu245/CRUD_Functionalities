package com.example.first_app.repositry;

import com.example.first_app.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRespository extends CrudRepository<Book, Integer> {
    Iterable<Book> findAll();
}
