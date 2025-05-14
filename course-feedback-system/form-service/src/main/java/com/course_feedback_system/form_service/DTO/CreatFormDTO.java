package com.course_feedback_system.form_service.DTO;

import java.lang.reflect.Type;

public class CreatFormDTO {
    public FeedbackFormType Type;
    public enum FeedbackFormType {
        COURSE,
        INSTRUCTOR
    }
    public Long referenceId;
}
