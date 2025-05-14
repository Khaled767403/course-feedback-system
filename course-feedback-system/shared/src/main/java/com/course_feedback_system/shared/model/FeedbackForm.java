//package com.course_feedback_system.shared.model;
//
//import jakarta.persistence.*;
//import java.util.List;
//import lombok.Getter;
//import lombok.Setter;
//
//
//@Getter
//@Setter
//@Entity
//@Table(name = "feedbackforms")
//public class FeedbackForm {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "course_id", referencedColumnName = "id")
//    private Course course;
//
//    @ManyToOne
//    @JoinColumn(name = "created_by", referencedColumnName = "id")
//    private User createdBy;
//
//    private Boolean active;
//
//    private java.sql.Timestamp createdAt;
//
//    // Getters and setters
//}
package com.course_feedback_system.shared.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "feedbackforms")
public class FeedbackForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "instructor_id", referencedColumnName = "id")
    private User instructor;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private User createdBy;

    private Boolean active;

    private java.sql.Timestamp createdAt;



    @Enumerated(EnumType.STRING)
    private FeedbackFormType type;  // COURSE or INSTRUCTOR

    private Long referenceId;  // This can be either courseId or instructorId based on type

    // Getters and Setters
    public Long getReferenceId() {
        if (type == FeedbackFormType.COURSE) {
            return course != null ? course.getId() : null;
        } else if (type == FeedbackFormType.INSTRUCTOR) {
            return instructor != null ? instructor.getId() : null;
        }
        return null;
    }


    public enum FeedbackFormType {
        COURSE,
        INSTRUCTOR
    }
}
