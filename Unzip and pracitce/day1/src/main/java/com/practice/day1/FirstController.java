package com.practice.day1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/user/post")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Autowired
    public String printUser( @RequestBody Order order){
        return "welcome the order details are " + order.toString();
    }

}
