package com.course_feedback_system.analytics_service;


import com.course_feedback_system.shared.config.commonConfig;
import jakarta.annotation.PostConstruct;
import lombok.Value;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EnableAspectJAutoProxy
@EntityScan("com.course_feedback_system.shared.model")
@SpringBootApplication
@Import(commonConfig.class)
public class AnalyticsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnalyticsServiceApplication.class, args);
	}

	@PostConstruct
	public void init() {
		System.out.println("Analytics Service is up and running!");
	}
}
