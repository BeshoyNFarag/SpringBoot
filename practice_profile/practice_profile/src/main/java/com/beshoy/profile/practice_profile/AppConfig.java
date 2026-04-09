package com.beshoy.profile.practice_profile;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {
    @Bean
    @Profile("dev")
    @Primary
    public FirstService firstService(){
        return new FirstService();
    }

    @Bean
    @Profile("dev")
    @Primary
    public FirstClass firstClass(){
        return new FirstClass(firstService());
    }


    @Bean
    @Profile("test")
    public FirstService firstServiceTest(){
        return new FirstService();
    }


    @Bean
    @Profile("test")
    public FirstClass testClassTest(){
        return new FirstClass(firstServiceTest());
    }



}
