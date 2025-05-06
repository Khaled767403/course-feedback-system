package com.course_feedback_system.form_service.controller;

import com.course_feedback_system.form_service.service.IFormService;
import com.course_feedback_system.shared.model.FeedbackForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/forms")
@RequiredArgsConstructor
public class FormController {

    private final IFormService formService;

    @GetMapping
    public List<FeedbackForm> getAllForms() {
        return formService.getAllForms();
    }

    @GetMapping("/{id}")
    public Optional<FeedbackForm> getFormById(@PathVariable Long id) {
        return formService.getFormById(id);
    }

    @PostMapping
    public FeedbackForm createForm(@RequestBody FeedbackForm form) {
        return formService.createForm(form);
    }

    @DeleteMapping("/{id}")
    public void deleteForm(@PathVariable Long id) {
        formService.deleteForm(id);
    }
}
