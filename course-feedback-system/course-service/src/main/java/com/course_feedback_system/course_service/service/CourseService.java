// CourseService.java
package com.course_feedback_system.course_service.service;

import com.course_feedback_system.shared.model.Course;
import com.course_feedback_system.course_service.repository.CourseRepository;
import com.course_feedback_system.shared.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final RestTemplate restTemplate;
    public CourseService(CourseRepository courseRepository, RestTemplate restTemplate) {

        this.courseRepository = courseRepository;
        this.restTemplate = restTemplate;
    }
    @Value("${gateway.url}")
    private String gatewayUrl;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course saveCourse(Course course, String instructorEmail) {
        // Fetch instructor via API Gateway
        String userServiceUrl = gatewayUrl + "/api/users/email/" + instructorEmail;
        User instructor = restTemplate.getForObject(userServiceUrl, User.class);

        if (instructor == null) {
            throw new IllegalArgumentException("Instructor not found");
        }

        // Set instructor before saving
        course.setInstructor(instructor);
        return courseRepository.save(course);
    }
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public List<Course> getCoursesByInstructor(User instructor) {
        return courseRepository.findByInstructor(instructor);
    }

    public User fetchInstructorFromUserService(String email) {
        String userServiceUrl = gatewayUrl + "/api/users/email/" + email;
        return restTemplate.getForObject(userServiceUrl, User.class);
    }

}
