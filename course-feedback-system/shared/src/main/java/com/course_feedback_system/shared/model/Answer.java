package com.course_feedback_system.shared.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "submission_id", referencedColumnName = "id")
    private FeedbackSubmission submission;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Question question;

    private String answerText;

    private Integer rating;

    public Long getCourseId() {
        return submission != null && submission.getForm() != null
                ? submission.getForm().getCourse().getId()
                : null;
    }

    public Long getInstructorId() {
        return submission != null && submission.getForm() != null
                ? submission.getForm().getCourse().getInstructor().getId()
                : null;
    }
}
