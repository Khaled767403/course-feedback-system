package com.course_feedback_system.shared.model;
import jakarta.persistence.*;

import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // Getters and setters

    public enum Role {
        STUDENT,
        INSTRUCTOR,
        ADMIN
    }
}
