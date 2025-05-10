package com.feedback.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.course_feedback_system.shared.model.User; // Ensure correct User model import
import com.feedback.dto.RegisterRequest; // Ensure correct DTO import

@FeignClient(name = "user-service")
public interface UserClient {
    @PostMapping("/users/register")
    User registerUser(@RequestBody RegisterRequest request);

    @GetMapping("/users/check-email")
    boolean checkIfEmailExists(@RequestParam String email);

    @GetMapping("/api/users/email/{email}") // Ensure this matches user-service
    User getUserByEmail(@PathVariable String email);
}
