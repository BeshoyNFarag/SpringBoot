package com.practice.day1;


import org.springframework.stereotype.Component;


public class FirstClass {

    private final String message;

    public FirstClass(String message) {
        this.message = message;
    }

    public String printHello(){
       return "hello from my first class " + message;
    }
}
