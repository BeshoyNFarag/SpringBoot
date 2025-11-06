package com.day1.practice.day1;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean("firstClass")
    public MyFirstClass myFirstClass() {
        return new MyFirstClass("First Var");
    }
}
