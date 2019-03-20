package com.soa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SoaSoapServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoaSoapServiceApplication.class, args);
	}

}
