package com.HospitalMangagmentSystem.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class HospitalMangagmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalMangagmentSystemApplication.class, args);
	}

}
