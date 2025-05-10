package com.course_feedback_system.user_service.repository;

import com.course_feedback_system.shared.repository.GenericRepository;
import com.course_feedback_system.shared.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GenericRepository<User, Number> {
    User findByEmail(String email);
}
