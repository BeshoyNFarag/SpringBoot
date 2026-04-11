package com.practice.day1;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {


    @GetMapping("/users/1")
    @ResponseStatus(HttpStatus.OK)
    public String printMessage(){
        return "Hello Controller";
    }

    @GetMapping("/check")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String check(){

        return "Hello check Controller";
    }
}
