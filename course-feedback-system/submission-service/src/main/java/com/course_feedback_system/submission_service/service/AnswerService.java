package com.course_feedback_system.submission_service.service;

import com.course_feedback_system.shared.model.Answer;
import com.course_feedback_system.submission_service.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService implements IAnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public List<Answer> getAnswersBySubmissionId(Long submissionId) {
        return answerRepository.findBySubmissionId(submissionId);
    }

    @Override
    public Answer saveAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public List<Answer> getAnswersByQuestionAndSubmission(Long questionId, Long submissionId) {
        return answerRepository.findByQuestionIdAndSubmissionId(questionId, submissionId);
    }
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();}
}
