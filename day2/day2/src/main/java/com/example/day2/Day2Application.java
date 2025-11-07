package com.example.day2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Day2Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Day2Application.class);

		MyFirstService service = context.getBean(MyFirstService.class);
		System.out.println(service.printService());
		System.out.println(service.getVersion());
		System.out.println(service.getOsName());
		System.out.println(service.getAppName());
		System.out.println(service.getName());
		System.out.println(service.getPassword());
		System.out.println(service.getAnotherPassword());

	}

}
