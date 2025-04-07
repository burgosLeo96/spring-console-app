package com.leonardburgos.spring_console_app;

import com.leonardburgos.spring_console_app.services.TrainerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.SpringVersion;

@ComponentScan(basePackages = "com.leonardburgos.spring_console_app")
public class SpringConsoleAppApplication {

	public static void main(String[] args) {
		String version = SpringVersion.getVersion();
		System.out.println("Spring Core Version: " + version);

		// Application begins here
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConsoleAppApplication.class);

		TrainerService trainerService = context.getBean(TrainerService.class);

		trainerService.addTrainer("trainer1", "Leonard", "Burgos");
		System.out.println(trainerService.getTrainer("trainer1"));
		System.out.println(trainerService.getTrainer("trainer2"));

		context.close();
	}

}
