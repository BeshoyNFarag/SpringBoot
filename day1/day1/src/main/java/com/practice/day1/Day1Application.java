/*

Requirements
Create:
NotificationService
EmailService
SmsService

Steps
Define both services as @Service.
Create AlertController (or AppRunner).

Part A — Field Injection
Inject NotificationService using field injection.
Inside it, use EmailService.

Part B — Method Injection
Create another version:
Use @Autowired on a setter method in NotificationService
Inject SmsService via method injection
Expected outcome

Both implementations should function identically, but you should be able to observe structural differences.
*/

package com.practice.day1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day1Application {

	public static void main(String[] args) {

		var context = SpringApplication.run(Day1Application.class, args);

		ApplicationInfo firstClass = context.getBean(ApplicationInfo.class);
		System.out.println(firstClass.getMessage());
		System.out.println(firstClass.getVersion());

	}



}
