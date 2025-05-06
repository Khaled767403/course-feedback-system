package com.course_feedback_system.form_service.service;

import com.course_feedback_system.shared.model.FeedbackForm;
import java.util.List;
import java.util.Optional;

public interface IFormService {
    List<FeedbackForm> getAllForms();
    Optional<FeedbackForm> getFormById(Long id);
    FeedbackForm createForm(FeedbackForm form);
    void deleteForm(Long id);
}
