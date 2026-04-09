package com.beshoy.profile.practice2;

public class NotificationSenderProd implements NotificationService{

    public String sendMessage() {
        return "a message from the production";
    }
}
