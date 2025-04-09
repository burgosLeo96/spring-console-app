package com.leonardburgos.spring_console_app;

import com.leonardburgos.spring_console_app.services.TrainerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.SpringVersion;

import java.util.Scanner;

@Slf4j
@ComponentScan(basePackages = "com.leonardburgos.spring_console_app")
public class SpringConsoleAppApplication {

	private static void printMenu() {
		log.info("Select an option:");
		log.info("1. Add Trainee");
		log.info("2. Add Trainer");
		log.info("3. Get Trainee");
		log.info("4. Get Trainer");
		log.info("5. Exit");
	}

	public static void main(String[] args) {
		String version = SpringVersion.getVersion();
		System.out.println("Spring Console App version: " + version);
        log.info("Spring Core Version: {}", version);

		// Application begins here
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConsoleAppApplication.class);
		TrainerService trainerService = context.getBean(TrainerService.class);

		log.info("My Spring Gym Service");

		printMenu();

		int opc = -1;
		Scanner scanner = new Scanner(System.in);

		while(opc != 5) {
			opc = scanner.nextInt();

			switch (opc) {
				case 1:
					log.info("Adding Trainee...");
					break;
				case 2:
					log.info("Adding Trainer...");
					break;
				case 3:
					log.info("Getting Trainee...");
					break;
				case 4:
					log.info("Getting Trainer...");
					break;
				case 5:
					log.info("Exiting...");
					break;
				default:
					log.info("Invalid option. Please try again.");
			}
			printMenu();
		}

		trainerService.addTrainer("trainer1", "Leonard", "Burgos");

		log.info("Trainer retrieved: {}", trainerService.getTrainer("trainer1"));
		log.info("Trainer retrieved: {}", trainerService.getTrainer("trainer2"));

		context.close();
	}

}
