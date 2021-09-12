package com.sarvoftware.scheduler.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"com.sarvoftware.scheduler.model",
		"com.sarvoftware.scheduler.persistence.*",
		"com.sarvoftware.scheduler.web.*"})
@EntityScan(value = "com.sarvoftware.scheduler.persistence.entities")
@EnableJpaRepositories(basePackages= {"com.sarvoftware.scheduler.persistence.repositories"})
public class SchedulerWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerWebApplication.class, args);
	}

}
