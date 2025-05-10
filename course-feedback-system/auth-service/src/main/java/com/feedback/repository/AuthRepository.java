package com.feedback.repository;

import com.course_feedback_system.shared.model.User;
import com.course_feedback_system.shared.repository.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends GenericRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
