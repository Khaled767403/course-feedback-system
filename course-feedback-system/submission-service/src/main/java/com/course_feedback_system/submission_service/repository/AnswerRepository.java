package com.course_feedback_system.submission_service.repository;

import com.course_feedback_system.shared.model.Answer;
import com.course_feedback_system.shared.repository.GenericRepository;

import java.util.List;

public interface AnswerRepository extends GenericRepository<Answer, Long> {
    List<Answer> findBySubmissionId(Long submissionId);
    List<Answer> findByQuestionIdAndSubmissionId(Long questionId, Long submissionId);
}
