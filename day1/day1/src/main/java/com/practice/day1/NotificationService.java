
package com.practice.day1;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class NotificationService {


    @Autowired
    public EmailService emailService;


    private SmsService smsService;


    @Autowired
    public void setSmsService(SmsService smsService) {
        this.smsService = smsService;

    }

    public void sendSms(String phoneNumber, String message) {
        smsService.sendMessage(phoneNumber, message);
    }

    public void sendEmail(String emailAddress, String subject, String message) {
        emailService.sendEmail(emailAddress, subject, message);
    }
}
