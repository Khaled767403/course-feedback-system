package com.course_feedback_system.form_service;

import com.course_feedback_system.shared.config.commonConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@EnableAspectJAutoProxy
@SpringBootApplication
@EntityScan("com.course_feedback_system.shared.model")
@ComponentScan(basePackages = {
		"com.course_feedback_system.form_service",
		"com.course_feedback_system.shared"
})
@Import(commonConfig.class)
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
