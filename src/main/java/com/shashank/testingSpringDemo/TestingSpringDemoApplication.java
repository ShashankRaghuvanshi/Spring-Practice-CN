package com.shashank.testingSpringDemo;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class TestingSpringDemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(TestingSpringDemoApplication.class, args);
		System.out.println("Welcome ! please use size of table");
		Scanner sc = new Scanner(System.in);
		String size = sc.nextLine();
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Table longTable = (Table) context.getBean("longTable");
		
		Table shortTable = (Table) context.getBean("shortTable");
		
		if(size.equals("long")) {
			System.out.println(longTable.showDetails());
		}else {
			System.out.println(shortTable.showDetails());
		}
		
	}

}
