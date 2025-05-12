package com.feedback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@EnableFeignClients
@EnableAspectJAutoProxy
@EntityScan("com.course_feedback_system.shared.model")
@SpringBootApplication
public class AuthServiceApplication {
    public static void main(String[] args) { SpringApplication.run(AuthServiceApplication.class, args);
    }
}