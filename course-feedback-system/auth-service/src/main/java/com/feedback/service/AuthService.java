package com.feedback.service;

import com.feedback.dto.AuthRequest;
import com.feedback.dto.AuthResponse;
import com.feedback.dto.RegisterRequest;
import com.feedback.repository.AuthRepository;
import com.course_feedback_system.shared.model.User;
import com.course_feedback_system.shared.model.User.Role;
import com.feedback.security.JwtUtil;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserClient userClient;  // Call user-service
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse register(RegisterRequest request) {
        if (userClient.checkIfEmailExists(request.getEmail())) {
            return new AuthResponse("Email already in use", null);
        }

        request.setPassword(passwordEncoder.encode(request.getPassword()));

        // Call user-service to create the user
        User savedUser = userClient.registerUser(request);

        // Generate JWT token
        String token = jwtUtil.generateToken(savedUser.getEmail());

        return new AuthResponse("Registration successful", token);
    }


    public AuthResponse login(AuthRequest request) {
        // Call user-service to fetch user details instead of using local repository
        User user = userClient.getUserByEmail(request.getEmail());

        if (user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return new AuthResponse("Invalid credentials", null);
        }

        // Generate JWT Token for authenticated user
        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponse("Login successful", token);
    }

}
