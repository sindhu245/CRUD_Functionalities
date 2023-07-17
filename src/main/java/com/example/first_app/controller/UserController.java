package com.example.first_app.controller;

import com.example.first_app.configaration.firstAppConfig;
import com.example.first_app.service.BookServiceInter;
import com.example.first_app.service.UserInterface;
import com.example.first_app.service.UserObjectService;
import com.example.first_app.service.UserVerboseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    @Qualifier("objectService")
    UserInterface userObjectService;

    @Qualifier("verboseService")
    @Autowired
    UserInterface userVerboseService;

//    ApplicationContext context = new AnnotationConfigApplicationContext(firstAppConfig.class);
//    private UserInterface userObjectService = context.getBean(UserObjectService.class);

    @GetMapping("/getUserVerbose/{bookId}")
    public String getUserVerbose(@PathVariable("bookId") int id){
        return userVerboseService.getUserData(id);
    }

    @GetMapping("/getUserObject/{bookId}")
    public String getUserObject(@PathVariable("bookId") int id){
        return userObjectService.getUserData(id);
    }
}
