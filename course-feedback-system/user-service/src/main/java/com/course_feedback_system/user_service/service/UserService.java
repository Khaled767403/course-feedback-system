package com.course_feedback_system.user_service.service;

import com.course_feedback_system.shared.model.User;
import com.course_feedback_system.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.saveEntity(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
