package com.course_feedback_system.form_service.repository;

import com.course_feedback_system.shared.model.Question;
import com.course_feedback_system.shared.repository.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends GenericRepository<Question, Long> {
    List<Question> findByFormId(Long formId); // Get questions for a specific form
}
