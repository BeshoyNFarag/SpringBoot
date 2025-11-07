package com.example.day2;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfig {

    @Bean
    public MyFirstClass myFirstBean() {
        return new MyFirstClass("Hola");
    }


    @Bean
    @Primary
    public MyFirstClass mySecondBean() {
        return new MyFirstClass("zebi");
    }

    @Bean
    public MyFirstClass myThirdBean() {
        return new MyFirstClass("last");
    }
}
