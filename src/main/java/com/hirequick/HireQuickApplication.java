package com.hirequick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HireQuickApplication {

	public static void main(String[] args) {
		SpringApplication.run(HireQuickApplication.class, args);
	}

}
