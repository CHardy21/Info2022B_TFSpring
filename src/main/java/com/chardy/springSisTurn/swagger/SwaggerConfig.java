package com.chardy.springSisTurn.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SuppressWarnings("deprecation")
@EnableSwagger2
@Configuration
@EnableWebMvc
@EnableSwagger2WebMvc
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.chardy.springSisTurn.restcontroller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
				
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"API - Sistema de Turnos - Informatorio 2022 B",
				"Permite crear eventos únicos o recurrentes desde una organización y sacar turnos como usuario",
				"1.0",
				"http://chardy.com/terms",
				new springfox.documentation.service.Contact("CHardy E", "https://github.com/CHardy21/Info2022B_TFSpringt", "christianrh2000@hotmail.com"),
				"LICENSE",
				"LICENSE URL",
				Collections.emptyList()
				);
	}
}
