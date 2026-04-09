package com.practice.day1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:application-services.properties")
@Component
public class ApplicationInfo {


    @Value("${app.name}")
    private String message;

    @Value("${app.version}")
    private String version;

    public String getMessage() {
        return message;
    }

    public String getVersion() {
        return version;
    }





}
