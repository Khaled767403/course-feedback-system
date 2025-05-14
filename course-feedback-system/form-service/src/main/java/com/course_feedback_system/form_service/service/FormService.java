package com.course_feedback_system.form_service.service;

import com.course_feedback_system.form_service.repository.FormRepository;
import com.course_feedback_system.shared.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FormService implements IFormService {

    private final FormRepository formRepository;
    private CourseRepository courseRepository;
    private UserRepository userRepository;


    private RestTemplate restTemplate;



    @Override
    public List<FeedbackForm> getAllForms() {
        return formRepository.findAll();
    }

    @Override
    public Optional<FeedbackForm> getFormById(Long id) {
        return formRepository.findById(id);
    }

    @Override
    public FeedbackForm createForm(FeedbackForm form) {
        if (form.getType() == FeedbackForm.FeedbackFormType.COURSE) {
            Course course = courseRepository.findById(form.getReferenceId())
                    .orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + form.getReferenceId()));
            form.setCourse(course);
            form.setInstructor(null);
        } else if (form.getType() == FeedbackForm.FeedbackFormType.INSTRUCTOR) {
            User instructor = userRepository.findById(form.getReferenceId())
                    .orElseThrow(() -> new IllegalArgumentException("Instructor not found with id: " + form.getReferenceId()));
            form.setInstructor(instructor);
            form.setCourse(null);
        }

        return formRepository.save(form);
    }

    @Override
    public void deleteForm(Long id) {
        formRepository.deleteById(id);
    }
}
