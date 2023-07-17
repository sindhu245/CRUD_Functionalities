package com.example.first_app.service;

import com.example.first_app.model.Book;
import com.example.first_app.repositry.BookRespository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class UserObjectService implements UserInterface{
//    @Autowired
    BookRespository bookRespository;
    public UserObjectService(BookRespository bookRespository){
        this.bookRespository = bookRespository;
    }
    public String getUserData(int id) {
        String userJsonFormat;
        Book book =bookRespository.findById(id).orElse(null);
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        try {
            userJsonFormat = mapper.writeValueAsString(book);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(book.toString());
        return userJsonFormat;
    }
}
