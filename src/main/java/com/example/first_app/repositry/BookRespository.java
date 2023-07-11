package com.example.first_app.repositry;

import com.example.first_app.model.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@EnableAutoConfiguration
@Repository
public interface BookRespository extends CrudRepository<Books, Integer> {
}
