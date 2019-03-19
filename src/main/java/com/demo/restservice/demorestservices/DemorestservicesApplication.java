package com.demo.restservice.demorestservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.demo.restservice.demorestservices")
public class DemorestservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemorestservicesApplication.class, args);
	}

}
