package com.chardy.springSisTurn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication //(exclude = SecurityAutoConfiguration.class)
public class SpringSisTurnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSisTurnApplication.class, args);
	}

}
