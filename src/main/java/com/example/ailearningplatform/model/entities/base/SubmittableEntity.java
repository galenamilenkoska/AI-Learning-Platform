package com.example.ailearningplatform.model.entities.base;


import com.example.ailearningplatform.model.entities.grades.Grade;
import com.example.ailearningplatform.model.entities.users.Instructor;
import com.example.ailearningplatform.model.entities.users.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SubmittableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "submission_date", nullable = false)
    private LocalDateTime submissionDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Student submittedBy;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Student assignedTo;

    @ManyToOne
    @JoinColumn(name = "id")
    private Instructor gradedBy;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Instructor assignedBy;

    @ManyToOne
    @JoinColumn(name = "id")
    private Grade grade;

}
