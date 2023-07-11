package com.example.first_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class FirstAppApplication {

    public static void main(String args[]) {
        SpringApplication.run(FirstAppApplication.class, args);
    }
}
