package com.beshoy.profile.practice_profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeProfileApplication {

	public static void main(String[] args) {

		var context = SpringApplication.run(PracticeProfileApplication.class, args);
		FirstClass firstClass = context.getBean(FirstClass.class);
		firstClass.printMessage();

	}

}
