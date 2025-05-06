package com.course_feedback_system.form_service.service;

import com.course_feedback_system.form_service.repository.FormRepository;
import com.course_feedback_system.shared.model.FeedbackForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FormService implements IFormService {

    private final FormRepository FormRepository;

    @Override
    public List<FeedbackForm> getAllForms() {
        return FormRepository.findAll();
    }

    @Override
    public Optional<FeedbackForm> getFormById(Long id) {
        return FormRepository.findById(id);
    }

    @Override
    public FeedbackForm createForm(FeedbackForm form) {
        return FormRepository.save(form);
    }

    @Override
    public void deleteForm(Long id) {
        FormRepository.deleteById(id);
    }
}
