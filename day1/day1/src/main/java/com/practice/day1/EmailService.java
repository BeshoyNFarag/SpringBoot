package com.practice.day1;

import org.springframework.stereotype.Service;

@Service
public class EmailService {


    public void sendEmail(String from, String to, String message) {
        System.out.println(from + to + message);
    }


}
