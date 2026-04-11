package com.practice.day1;

import org.springframework.stereotype.Service;

@Service
public class SmsService {
    public void sendMessage(String phoneNumber, String message) {

        System.out.printf("this number %s got this message: %s", phoneNumber, message);
    }
}
