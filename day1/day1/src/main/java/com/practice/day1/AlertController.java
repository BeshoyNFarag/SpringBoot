package com.practice.day1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class AlertController implements CommandLineRunner {

    @Autowired
    public NotificationService notificationService;


    @Override
    public void run(String [] args)  {


        notificationService.sendSms("01625374811", "hey whats upp!");
        System.out.println();
        notificationService.sendEmail("Beshoy", "Internship", "Oh shit");

    }

}
