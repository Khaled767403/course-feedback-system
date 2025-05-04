// FeedbackSubmissionController.java
package com.course_feedback_system.submission_service.controller;

import com.course_feedback_system.shared.model.FeedbackSubmission;
import com.course_feedback_system.submission_service.service.FeedbackSubmissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
public class FeedbackSubmissionController {
    private final FeedbackSubmissionService submissionService;

    public FeedbackSubmissionController(FeedbackSubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @GetMapping
    public List<FeedbackSubmission> getAllSubmissions() {
        return submissionService.getAllSubmissions();
    }

    @GetMapping("/{id}")
    public FeedbackSubmission getSubmissionById(@PathVariable Long id) {
        return submissionService.getSubmissionById(id);
    }

    @PostMapping
    public FeedbackSubmission createSubmission(@RequestBody FeedbackSubmission submission) {
        return submissionService.saveSubmission(submission);
    }

    @DeleteMapping("/{id}")
    public void deleteSubmission(@PathVariable Long id) {
        submissionService.deleteSubmission(id);
    }
}
