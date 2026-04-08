package com.practice.day1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Day1Application {

	public static void main(String[] args) {

		var context = SpringApplication.run(Day1Application.class, args);
		MyFirstService firstService = context.getBean(MyFirstService.class);
		System.out.println(firstService.serviceMessage());
		System.out.println(firstService.getMyProp());



	}



}
