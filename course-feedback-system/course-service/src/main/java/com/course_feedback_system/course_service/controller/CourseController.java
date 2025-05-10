// CourseController.java
package com.course_feedback_system.course_service.controller;

import com.course_feedback_system.shared.model.Course;
import com.course_feedback_system.shared.model.User;
import com.course_feedback_system.course_service.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping("/createCourse")
    public ResponseEntity<Course> createCourse(@RequestBody Course course,
                                               @RequestHeader("X-User-Email") String instructorEmail) {
        // Fetch instructor from User Service via API Gateway
        User instructor = courseService.fetchInstructorFromUserService(instructorEmail);

        if (instructor == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // Set the instructor before saving the course
        course.setInstructor(instructor);
        Course savedCourse = courseService.saveCourse(course, instructorEmail);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCourse);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id,
                                          @RequestHeader("X-User-Email") String requesterEmail) {
        Course course = courseService.getCourseById(id);
        if (course == null) {
            return ResponseEntity.notFound().build();
        }

        // التأكد إن اللي بيطلب الحذف هو صاحب الكورس
        if (!course.getInstructor().getEmail().equals(requesterEmail)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not authorized to delete this course.");
        }

        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
