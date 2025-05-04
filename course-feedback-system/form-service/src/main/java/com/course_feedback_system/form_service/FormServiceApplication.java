package com.course_feedback_system.form_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.beans.factory.annotation.Value;
import jakarta.annotation.PostConstruct;

@EnableAspectJAutoProxy
@SpringBootApplication
@EntityScan("com.course_feedback_system.shared.model") // Ensure shared models are scanned
public class FormServiceApplication {

	@Value("${test.variable}")
	private String testVariable;

	@PostConstruct
	public void checkConfig() {
		System.out.println("Config Import Status: " + testVariable);
	}

	public static void main(String[] args) {
		SpringApplication.run(FormServiceApplication.class, args);
	}
}
