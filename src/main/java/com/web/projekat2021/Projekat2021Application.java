package com.web.projekat2021;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.web.projekat2021"})
public class Projekat2021Application {

	public static void main(String[] args) {
		SpringApplication.run(Projekat2021Application.class, args);

	}


}
