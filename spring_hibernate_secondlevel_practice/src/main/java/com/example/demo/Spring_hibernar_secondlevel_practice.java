package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Spring_hibernar_secondlevel_practice {

	public static void main(String[] args) {
		SpringApplication.run(Spring_hibernar_secondlevel_practice.class, args);
	}

}
