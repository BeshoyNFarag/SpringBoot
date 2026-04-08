package com.practice.day1;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean("First")
   public FirstClass myFirstClassBean(){
       return new FirstClass("Spring boot");
   }
    @Bean("Second")
    public FirstClass mySecondClassBean(){
        return new FirstClass("Spring boot second bean");
    }

    @Bean
    @Primary
    public FirstClass myThirdClassBean(){
        return new FirstClass("Spring boot primary bean");
    }


}
