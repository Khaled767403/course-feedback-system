package com.course_feedback_system.form_service.repository;

import com.course_feedback_system.shared.model.Course;
import com.course_feedback_system.shared.model.FeedbackForm;
import com.course_feedback_system.shared.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public class formRepository extends GenericRepository<FeedbackForm> {
    public formRepository(JpaRepository<FeedbackForm, Long> jpaRepository) {
        super(jpaRepository);
    }
}



