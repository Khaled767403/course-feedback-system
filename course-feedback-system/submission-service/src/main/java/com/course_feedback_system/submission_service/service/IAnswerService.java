package com.course_feedback_system.submission_service.service;

import com.course_feedback_system.shared.model.Answer;

import java.util.List;

public interface IAnswerService {

    List<Answer> getAnswersBySubmissionId(Long submissionId);

    Answer saveAnswer(Answer answer);

    List<Answer> getAnswersByQuestionAndSubmission(Long questionId, Long submissionId);

    public List<Answer> getAllAnswers();
}
