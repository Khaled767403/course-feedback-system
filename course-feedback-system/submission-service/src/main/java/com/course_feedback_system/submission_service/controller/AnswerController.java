package com.course_feedback_system.submission_service.controller;

import com.course_feedback_system.shared.model.Answer;
import com.course_feedback_system.submission_service.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")  // Updated root path for answers API
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping("/all")
    public List<Answer> getAllAnswers() {
        return answerService.getAllAnswers();
    }

    // Fetch all answers for a specific feedback submission
    @GetMapping("/submission/{submissionId}")
    public List<Answer> getAnswersBySubmissionId(@PathVariable Long submissionId) {
        return answerService.getAnswersBySubmissionId(submissionId);
    }

    // Save a new answer
    @PostMapping("/createAnswer")
    public Answer saveAnswer(@RequestBody Answer answer) {
        return answerService.saveAnswer(answer);
    }

    // Fetch answers based on question and submission
    @GetMapping("/submission/{submissionId}/question/{questionId}")
    public List<Answer> getAnswersByQuestionAndSubmission(
            @PathVariable Long submissionId,
            @PathVariable Long questionId
    ) {
        return answerService.getAnswersByQuestionAndSubmission(questionId, submissionId);
    }
}
