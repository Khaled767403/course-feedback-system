package com.course_feedback_system.submission_service.repository;

import com.course_feedback_system.shared.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    // جلب جميع الإجابات الخاصة بـ FeedbackSubmission معينة
    List<Answer> findBySubmissionId(Long submissionId);

    // جلب إجابة بناءً على السؤال و FeedbackSubmission
    List<Answer> findByQuestionIdAndSubmissionId(Long questionId, Long submissionId);
}
