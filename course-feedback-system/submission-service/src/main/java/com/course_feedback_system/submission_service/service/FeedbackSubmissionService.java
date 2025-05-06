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
        return submissionRepository.save(submission);
    }

    public void deleteSubmission(Long id) {
        submissionRepository.deleteById(id);
    }
    public List<FeedbackSubmission> getSubmissionsByCourseId(Long courseId) {
        return submissionRepository.findByForm_Course_Id(courseId);
    }

    public List<FeedbackSubmission> getSubmissionsByInstructorId(Long instructorId) {
        return submissionRepository.findByForm_Course_Instructor_Id(instructorId);
    }


}