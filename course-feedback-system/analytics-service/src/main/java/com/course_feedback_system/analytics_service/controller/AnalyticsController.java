package com.course_feedback_system.analytics_service.controller;

import com.course_feedback_system.analytics_service.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @GetMapping("/summary/course/{courseId}")
    public Map<String, Object> getCourseSummary(@PathVariable Long courseId) {
        return analyticsService.getCourseFeedbackSummary(courseId);
    }

    @GetMapping("/summary/instructor/{instructorId}")
    public Map<String, Object> getInstructorSummary(@PathVariable Long instructorId) {
        return analyticsService.getInstructorFeedbackSummary(instructorId);
    }

    @GetMapping("/top-courses")
    public List<Map<String, Object>> getTopRatedCourses(@RequestParam(defaultValue = "5") int limit) {
        return analyticsService.getTopRatedCourses(limit);
    }

    @GetMapping("/top-instructors")
    public List<Map<String, Object>> getTopRatedInstructors(@RequestParam(defaultValue = "5") int limit) {
        return analyticsService.getTopRatedInstructors(limit);
    }
}
