package com.example.CustomerServicedemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.Customers.CustomerCare;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerServicedemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(CustomerServicedemoApplication.class, args);

		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		CustomerCare customerCare = null;
		String service = null;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to our Customer Care application ");
		System.out.print("Please enter your name: ");
		String customerName = scanner.nextLine();

		System.out.println("Thanks for reaching us " + customerName);
		System.out.println("Please select a department to connect to:");
		System.out.println("1. Payment Department");
		System.out.println("2. Query Department");
		System.out.println("3. Sales Department");
		System.out.println("0. Exit");

		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character

		if (choice >= 0 && choice < 4) {
			switch (choice) {

			case 1:
				service = "paymentDepartment";
				break;
			case 2:
				service = "queryDepartment";
				break;
			case 3:
				service = "salesDepartment";
				break;

			default:
				System.out.println("You have exited the application.");
			}
			// getting the implemented services

			customerCare = service != null ? (CustomerCare) context.getBean(service) : null;
			customerCare.setCustomerName(customerName);
			customerCare.getService();

			String Issue = scanner.nextLine();
			customerCare.setProblem(Issue);
			customerCare.getProblem();

		}

		else {
			System.out.println(
					"You have given an wrong Input would you like to continue using the Customer Care application? y/n");
			String wanttoContinue = scanner.nextLine(); // Consume the newline character
			System.out.println(wanttoContinue);
			if (wanttoContinue.equals("y")) {
				System.out.println("entered loop");
				main(null);
			} else {
				System.out.println("You have exited the Application");

			}
		}
	}
}
