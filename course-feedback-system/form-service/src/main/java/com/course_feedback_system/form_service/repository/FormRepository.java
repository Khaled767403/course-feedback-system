package com.course_feedback_system.form_service.repository;

import com.course_feedback_system.shared.model.FeedbackForm;
import com.course_feedback_system.shared.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends GenericRepository<FeedbackForm, Number> {
}
