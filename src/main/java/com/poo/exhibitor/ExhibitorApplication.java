package com.poo.exhibitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ExhibitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExhibitorApplication.class, args);
	}

}
