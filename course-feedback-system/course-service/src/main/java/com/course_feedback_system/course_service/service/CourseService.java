// CourseService.java
package com.course_feedback_system.course_service.service;

import com.course_feedback_system.shared.model.Course;
import com.course_feedback_system.course_service.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course saveCourse(Course course) {
        return courseRepository.saveEntity(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
