package com.example.day2;

public class MyFirstClass {

    private final String message;

    public MyFirstClass(String message) {
        this.message = message;
    }

    public String printHello(){
        return "Hello World " + message;
    }
}
