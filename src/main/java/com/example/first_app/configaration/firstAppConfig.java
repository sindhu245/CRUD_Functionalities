package com.example.first_app.configaration;

import com.example.first_app.repositry.BookRespository;
import com.example.first_app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class firstAppConfig {
    @Autowired
    BookRespository bookRespository;

    @Bean
    @Qualifier("objectService")
    public UserInterface getUserObjectService(){
        return new UserObjectService(bookRespository);
    }

    @Bean
    @Qualifier("verboseService")
    public UserInterface getUserVerboseService(){
        return new UserVerboseService(bookRespository);
    }
}
