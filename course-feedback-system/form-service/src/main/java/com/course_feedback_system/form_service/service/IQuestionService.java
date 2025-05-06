package com.course_feedback_system.form_service.service;

import com.course_feedback_system.shared.model.Question;
import java.util.List;
import java.util.Optional;

public interface IQuestionService {
    List<Question> getQuestionsByFormId(Long formId);
    Optional<Question> getQuestionById(Long id);
    Question createQuestion(Question question);
    void deleteQuestion(Long id);
}
