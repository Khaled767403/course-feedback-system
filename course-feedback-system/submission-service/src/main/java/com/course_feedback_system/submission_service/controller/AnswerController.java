package com.course_feedback_system.submission_service.controller;

import com.course_feedback_system.shared.model.Answer;
import com.course_feedback_system.submission_service.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    // جلب جميع الإجابات الخاصة بـ FeedbackSubmission
    @GetMapping("/submission/{submissionId}")
    public List<Answer> getAnswersBySubmissionId(@PathVariable Long submissionId) {
        return answerService.getAnswersBySubmissionId(submissionId);
    }

    // حفظ إجابة جديدة
    @PostMapping
    public Answer saveAnswer(@RequestBody Answer answer) {
        return answerService.saveAnswer(answer);
    }

    // جلب الإجابات بناءً على السؤال و FeedbackSubmission
    @GetMapping("/submission/{submissionId}/question/{questionId}")
    public List<Answer> getAnswersByQuestionAndSubmission(
            @PathVariable Long submissionId,
            @PathVariable Long questionId
    ) {
        return answerService.getAnswersByQuestionAndSubmission(questionId, submissionId);
    }
}
