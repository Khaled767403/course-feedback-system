// In user-service subproject
package com.course_feedback_system.user_service.repository;

import com.course_feedback_system.shared.model.Course;
import com.course_feedback_system.shared.repository.GenericRepository;
import com.course_feedback_system.shared.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository  extends GenericRepository<User> {
    public UserRepository(JpaRepository<User, Long> jpaRepository) {
        super(jpaRepository);
    }


    // You can add custom queries or methods for User if needed
}
