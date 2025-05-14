package com.course_feedback_system.form_service.controller;

import com.course_feedback_system.form_service.service.IFormService;
import com.course_feedback_system.shared.model.FeedbackForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/forms")
@RequiredArgsConstructor
public class FormController {

    private final IFormService formService;

    @GetMapping("/all")
    public List<FeedbackForm> getAllForms() {
        return formService.getAllForms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackForm> getFormById(@PathVariable Long id) {
        Optional<FeedbackForm> form = formService.getFormById(id);
        if (form.isPresent()) {
            return ResponseEntity.ok(form.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/createForm")
    public ResponseEntity<FeedbackForm> createForm(@RequestBody FeedbackForm form) {
        FeedbackForm createdForm = formService.createForm(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdForm);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteForm(@PathVariable Long id) {
        Optional<FeedbackForm> form = formService.getFormById(id);
        if (form.isPresent()) {
            formService.deleteForm(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
