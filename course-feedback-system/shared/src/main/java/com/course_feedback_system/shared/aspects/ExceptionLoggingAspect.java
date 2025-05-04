package com.course_feedback_system.shared.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionLoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(ExceptionLoggingAspect.class);

    @AfterThrowing(pointcut = "execution(* com.yourpackage..*(..))", throwing = "ex")
    public void logExceptions(JoinPoint joinPoint, Throwable ex) {
        logger.error("Exception in method: {} with message: {}", joinPoint.getSignature(), ex.getMessage(), ex);
    }
}
