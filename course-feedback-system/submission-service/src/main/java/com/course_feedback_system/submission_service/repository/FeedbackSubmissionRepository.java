package com.course_feedback_system.submission_service.repository;

import com.course_feedback_system.shared.model.FeedbackSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FeedbackSubmissionRepository extends JpaRepository<FeedbackSubmission, Long> {
    List<FeedbackSubmission> findByForm_Course_Id(Long courseId);
    List<FeedbackSubmission> findByForm_Course_Instructor_Id(Long instructorId);}
