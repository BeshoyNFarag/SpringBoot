package com.day1.practice.day1;


import org.springframework.stereotype.Component;


public class MyFirstClass {

    private String myVar;

    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String Hello(){
        return "Hello from MyFirstClass " + myVar;
    }
}
