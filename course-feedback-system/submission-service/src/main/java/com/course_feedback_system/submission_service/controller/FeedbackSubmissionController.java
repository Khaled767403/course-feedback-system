package com.course_feedback_system.submission_service.controller;

import com.course_feedback_system.shared.model.Answer;
import com.course_feedback_system.shared.model.FeedbackSubmission;
import com.course_feedback_system.submission_service.service.AnswerService;
import com.course_feedback_system.submission_service.service.FeedbackSubmissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
public class FeedbackSubmissionController {

    private final FeedbackSubmissionService feedbackSubmissionService;
    private final AnswerService answerService;

    // ✅ Constructor-based injection for better testability
    public FeedbackSubmissionController(FeedbackSubmissionService feedbackSubmissionService, AnswerService answerService) {
        this.feedbackSubmissionService = feedbackSubmissionService;
        this.answerService = answerService;
    }

    // ✅ Create a new submission
    @PostMapping("/createSubmission")
    public FeedbackSubmission createSubmission(@RequestBody FeedbackSubmission submission) {
        return feedbackSubmissionService.saveSubmission(submission);
    }

    // ✅ Get submissions by course ID
    @GetMapping("/course/{courseId}")
    public List<FeedbackSubmission> getSubmissionsByCourseId(@PathVariable Long courseId) {
        return feedbackSubmissionService.getSubmissionsByCourseId(courseId);
    }

    // ✅ Get submissions by instructor ID
    @GetMapping("/instructor/{instructorId}")
    public List<FeedbackSubmission> getSubmissionsByInstructorId(@PathVariable Long instructorId) {
        return feedbackSubmissionService.getSubmissionsByInstructorId(instructorId);
    }

    // ✅ Get answers for a specific submission
    @GetMapping("/{submissionId}/answers")
    public List<Answer> getAnswersBySubmission(@PathVariable Long submissionId) {
        return answerService.getAnswersBySubmissionId(submissionId);
    }
}
