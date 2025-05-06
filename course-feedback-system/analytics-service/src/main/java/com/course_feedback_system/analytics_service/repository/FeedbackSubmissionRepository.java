package com.course_feedback_system.analytics_service.repository;

import com.course_feedback_system.shared.model.FeedbackSubmission;
import com.course_feedback_system.shared.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackSubmissionRepository extends GenericRepository<FeedbackSubmission, Long> {
    // يمكنك إضافة أي دوال مخصصة هنا إذا لزم الأمر
}
