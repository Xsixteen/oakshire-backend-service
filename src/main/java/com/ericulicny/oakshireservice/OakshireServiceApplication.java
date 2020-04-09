package com.ericulicny.oakshireservice;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@SpringBootApplication
@EnableJpaRepositories
@EnableScheduling
public class OakshireServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OakshireServiceApplication.class, args);
	}

	@Bean(destroyMethod = "shutdown")
	public Executor taskScheduler() {
		return Executors.newScheduledThreadPool(3);
	}

}
