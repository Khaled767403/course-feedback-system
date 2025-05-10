package com.feedback.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String role; // STUDENT, INSTRUCTOR, ADMIN
}
