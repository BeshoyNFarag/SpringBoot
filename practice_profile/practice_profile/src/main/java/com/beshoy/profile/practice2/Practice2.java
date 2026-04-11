/*
Design a Spring Boot application component that sends notifications, with behavior that changes
depending on the active environment using profiles.

Functional Requirements
You are building a Notification Service that supports sending messages to users.
The system must behave differently depending on the active profile:

1. Development (dev)
Do NOT send real notifications
Instead, log or print the message
This acts as a safe testing environment

2. Testing (test)
Simulate sending notifications
Store sent messages in memory (e.g., a list)
Allow retrieval of sent messages for verification purposes

3. Production (prod)
Simulate a “real” notification sender
You can assume integration with an external system (no real API needed)
Focus on structure, not actual external calls
Technical Requirements

1. Use OOP principles
Define a clear abstraction for sending notifications
Apply:
Interface or abstract class
Proper separation of concerns
Clean method design

2. Use Dependency Injection
Inject the correct implementation into your service
Ensure your main service is not aware of the environment directly

3. Use Spring Profiles
Use @Profile to control which implementation is active
Ensure only ONE implementation is active per profile (unless intentionally combining)

4. Configuration
Use profile-specific configuration files to:
Change logging level
Optionally define a “sender name” or similar property
Expected Design (High-Level)

You should end up with:
A NotificationService (core service used by the application)
A NotificationSender abstraction
Multiple implementations:
Dev version
Test version
Prod version
Profile-based activation of each implementation
Constraints
Do NOT use conditional logic like:
if (env == "dev")
Do NOT hardcode environment checks
The system must rely entirely on:
Spring DI
@Profile
* */

package com.beshoy.profile.practice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Practice2 {

    public static void main(String[] args) {

        var context = SpringApplication.run(Practice2.class, args);
        NotificationService notificationService = context.getBean(NotificationService.class);
        System.out.println(notificationService.sendMessage());


    }

}
