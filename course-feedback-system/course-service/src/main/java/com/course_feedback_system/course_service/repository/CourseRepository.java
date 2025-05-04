package com.course_feedback_system.course_service.repository;

import com.course_feedback_system.shared.model.Course;
import com.course_feedback_system.shared.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends GenericRepository<Course> {
}
