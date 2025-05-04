package com.course_feedback_system.submission_service.repository;

import com.course_feedback_system.shared.model.FeedbackSubmission;
import com.course_feedback_system.shared.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackSubmissionRepository extends GenericRepository<FeedbackSubmission> {
}
