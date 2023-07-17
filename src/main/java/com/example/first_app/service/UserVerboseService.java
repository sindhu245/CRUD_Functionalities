package com.example.first_app.service;

import com.example.first_app.model.Book;
import com.example.first_app.repositry.BookRespository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

//@Service
public class UserVerboseService implements UserInterface{
//    @Autowired
    BookRespository bookRespository;
    public UserVerboseService(BookRespository bookRespository){
        this.bookRespository = bookRespository;
    }
    public String getUserData(int id) {
        String verboseFormat = "";
        Book book = bookRespository.findById(id).get();
        Field[] fields = book.getClass().getDeclaredFields();

        for (Field field: fields) {
            try {
                field.setAccessible(true);
                verboseFormat += field.getName() + ":" + String.valueOf(field.get(book)) + "::";
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return verboseFormat;
    }
}