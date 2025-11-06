package com.day1.practice.day1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Service("firstService")
public class MyFirstService {

    private final MyFirstClass myFirstClass;

    @Autowired
    public MyFirstService(MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }
    @GetMapping("/service")
    public String callService(){
        return "My first service says: " + myFirstClass.Hello() ;
    }
}
