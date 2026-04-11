package com.beshoy.profile.practice2;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean
    @Profile("dev")
    public NotificationSenderDev notificationSenderDev() {
        return new NotificationSenderDev();
    }
    @Bean
    @Profile("test")
    public NotificationSenderTest notificationSenderTest() {
        return new NotificationSenderTest();
    }
    @Bean
    @Profile("prod")
    public NotificationSenderProd notificationSenderProd() {
        return new NotificationSenderProd();
    }


}
