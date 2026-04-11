package com.beshoy.profile.practice_profile;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;


@PropertySource("classpath:application.properties")
public class FirstClass {


    @Value("${my.profile.message}")
    private String message;
    private final FirstService firstService;

    @Autowired
    public FirstClass(FirstService firstService) {
        this.firstService = firstService;
    }

    public void printMessage() {
        firstService.printMessage(message);
    }








}
