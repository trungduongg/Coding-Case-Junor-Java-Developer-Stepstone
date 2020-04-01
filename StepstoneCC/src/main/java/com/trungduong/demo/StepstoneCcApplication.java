package com.trungduong.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StepstoneCcApplication {
	public static String firstName, lastName;

	public static void main(String[] args) {
		SpringApplication.run(StepstoneCcApplication.class, args);

		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to Trung Quoc Duong's solution for Coding Case Stepstone (complex solution)");
		System.out.println("First name: ");
		firstName = in.nextLine();
		System.out.println("Last name: ");
		lastName = in.nextLine();
		in.close();
	}

}
