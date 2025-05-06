package com.course_feedback_system.analytics_service.service;

import java.util.List;
import java.util.Map;

public interface IAnalyticsService {

    Map<String, Object> getCourseFeedbackSummary(Long courseId);

    Map<String, Object> getInstructorFeedbackSummary(Long instructorId);

    List<Map<String, Object>> getTopRatedCourses(int limit);

    List<Map<String, Object>> getTopRatedInstructors(int limit);
}
