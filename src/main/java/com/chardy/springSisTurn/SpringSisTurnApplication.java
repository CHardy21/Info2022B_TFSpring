package com.chardy.springSisTurn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication //(exclude = SecurityAutoConfiguration.class)
public class SpringSisTurnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSisTurnApplication.class, args);
	}

}
