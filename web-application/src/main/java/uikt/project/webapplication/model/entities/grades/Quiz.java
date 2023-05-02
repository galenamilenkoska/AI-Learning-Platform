package com.example.ailearningplatform.model.entities.grades;


import com.example.ailearningplatform.model.entities.base.SubmittableEntity;
import com.example.ailearningplatform.model.entities.users.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz extends SubmittableEntity {

    @Column(name = "quiz_title", nullable = false)
    private String title;

    @Column(name = "total_attempts", nullable = false)
    private Integer totalAttempts;

    @Column(name = "time_limit", nullable = false)
    private LocalDateTime timeLimit;

    @Column(name = "date_published", nullable = false)
    private LocalDate datePublished;










}
