package com.course_feedback_system.submission_service.controller;

import com.course_feedback_system.shared.model.Answer;
import com.course_feedback_system.shared.model.FeedbackSubmission;
import com.course_feedback_system.submission_service.service.AnswerService;
import com.course_feedback_system.submission_service.service.FeedbackSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
public class FeedbackSubmissionController {

    @Autowired
    private FeedbackSubmissionService feedbackSubmissionService;

    @Autowired
    private AnswerService answerService;  // تم إضافته بشكل صحيح

    @GetMapping("/form/{courseId}")
    public List<FeedbackSubmission> getSubmissionsByCourseId(@PathVariable Long courseId) {
        return feedbackSubmissionService.getSubmissionsByCourseId(courseId);
    }

    @GetMapping("/instructor/{instructorId}")
    public List<FeedbackSubmission> getSubmissionsByInstructorId(@PathVariable Long instructorId) {
        return feedbackSubmissionService.getSubmissionsByInstructorId(instructorId);
    }

    @GetMapping("/answers")
    public List<Answer> getAllAnswers() {
        return answerService.getAllAnswers();  // الآن لن يحدث NullPointerException
    }
}
