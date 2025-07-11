package com.course_feedback_system.course_service.repository;

import com.course_feedback_system.shared.model.Course;
import com.course_feedback_system.shared.model.User;
import com.course_feedback_system.shared.repository.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends GenericRepository<Course, Long> {

    // Method to get courses by the instructor
    List<Course> findByInstructor(User instructor);
}
