package com.course_feedback_system.shared.model;

import jakarta.persistence.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "form_id", referencedColumnName = "id")
    private FeedbackForm form;

    private String text;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    // Getters and setters

    public enum QuestionType {
        TEXT,
        RATING
    }
}
