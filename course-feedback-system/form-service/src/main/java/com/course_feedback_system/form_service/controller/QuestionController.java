package com.course_feedback_system.form_service.controller;

import com.course_feedback_system.form_service.service.IQuestionService;
import com.course_feedback_system.shared.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final IQuestionService questionService;

    @GetMapping("/form/{formId}")
    public List<Question> getQuestionsByForm(@PathVariable Long formId) {
        return questionService.getQuestionsByFormId(formId);
    }

    @GetMapping("/{id}")
    public Optional<Question> getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        return questionService.createQuestion(question);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }
}
