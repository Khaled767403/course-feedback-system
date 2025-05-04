// FeedbackSubmissionService.java
package com.course_feedback_system.submission_service.service;

import com.course_feedback_system.shared.model.FeedbackSubmission;
import com.course_feedback_system.submission_service.repository.FeedbackSubmissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackSubmissionService {
    private final FeedbackSubmissionRepository submissionRepository;

    public FeedbackSubmissionService(FeedbackSubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    public List<FeedbackSubmission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    public FeedbackSubmission getSubmissionById(Long id) {
        return submissionRepository.findById(id).orElse(null);
    }

    public FeedbackSubmission saveSubmission(FeedbackSubmission submission) {
        return submissionRepository.saveEntity(submission);
    }

    public void deleteSubmission(Long id) {
        submissionRepository.deleteById(id);
    }
}