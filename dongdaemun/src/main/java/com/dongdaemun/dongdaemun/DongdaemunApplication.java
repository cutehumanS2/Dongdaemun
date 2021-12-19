package com.dongdaemun.dongdaemun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DongdaemunApplication {

	public static void main(String[] args) {
		SpringApplication.run(DongdaemunApplication.class, args);
	}

}
