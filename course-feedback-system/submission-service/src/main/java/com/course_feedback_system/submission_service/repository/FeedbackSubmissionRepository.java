package com.course_feedback_system.submission_service.repository;

import com.course_feedback_system.shared.model.FeedbackSubmission;
import com.course_feedback_system.shared.repository.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public class FeedbackSubmissionRepository extends GenericRepository<FeedbackSubmission>{


    public FeedbackSubmissionRepository(JpaRepository<FeedbackSubmission, Long> jpaRepository) {
        super(jpaRepository);
    }
}
