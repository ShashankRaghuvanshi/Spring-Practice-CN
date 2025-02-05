package com.example.tax;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class TaxApplication {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Tax Payment Application");
		while (true) {
			System.out.println("Please select which tax you want to pay: \n1. Income \n2. Property\n3. Exit");
			int userChoice = scanner.nextInt();
			String taxChoice = "";
			switch (userChoice) {
				case 1 -> taxChoice = "incomeTax";
				case 2 -> taxChoice = "propertyTax";
				case 3 -> {
					System.out.println("Exiting...");
					return;
				}
				default -> {
					System.out.println("Invalid choice");
					return;
				}
			}
			//Part 3
			Tax tax = (Tax) context.getBean(taxChoice);
			if(tax.isTaxPayed()){
				System.out.println("You have already payed " + tax.getTaxType() + " tax.");
			}
			else {
				System.out.println("Please enter your Income/Property value:");
				int taxableAmount = scanner.nextInt();
				tax.setTaxableAmount(taxableAmount);
				tax.calculateTaxAmount();
				System.out.println("You have selected " + tax.getTaxType() + " tax and your tax amount is: " + tax.getTaxAmount());
				System.out.println("Do you want to pay the tax: \n1. Yes\n2. Exit");
				int choice = scanner.nextInt();
				if(choice == 1){
					tax.payTax();
				}
				else{
					return;
				}
			}
		}
	}

}
