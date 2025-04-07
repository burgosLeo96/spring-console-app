package com.leonardburgos.spring_console_app;

import com.leonardburgos.spring_console_app.services.TrainerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.SpringVersion;

@Slf4j
@ComponentScan(basePackages = "com.leonardburgos.spring_console_app")
public class SpringConsoleAppApplication {

	public static void main(String[] args) {
		String version = SpringVersion.getVersion();
        log.info("Spring Core Version: {}", version);

		// Application begins here
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConsoleAppApplication.class);

		TrainerService trainerService = context.getBean(TrainerService.class);

		trainerService.addTrainer("trainer1", "Leonard", "Burgos");

		log.info("Trainer retrieved: {}", trainerService.getTrainer("trainer1"));
		log.info("Trainer retrieved: {}", trainerService.getTrainer("trainer2"));

		context.close();
	}

}
