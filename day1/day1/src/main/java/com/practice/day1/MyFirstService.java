package com.practice.day1;


import com.practice.day1.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:custom.properties")
public class MyFirstService {

    private final FirstClass firstClass;

    @Value("${beshoy.prop}")
    private String myProp;


    @Autowired
    public MyFirstService( FirstClass firstClass) {
        this.firstClass = firstClass;

    }


    public String serviceMessage() {
        return "First service + first class: " + firstClass.printHello();
    }




    public String getMyProp() {
        return myProp;
    }


}
