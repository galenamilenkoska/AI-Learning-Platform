package uikt.project.webapplication.model.entities.base;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.grades.Grade;
import uikt.project.webapplication.model.entities.users.Instructor;
import uikt.project.webapplication.model.entities.users.Student;

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
    @JoinColumn(name = "submitted_by_student_id")
    private Student submittedBy;

    @ManyToOne(optional = false)
    @JoinColumn(name = "assignted_to_student_id")
    private Student assignedTo;

    @ManyToOne
    @JoinColumn(name = "graded_by_instructor_id")
    private Instructor gradedBy;

    @ManyToOne
    @JoinColumn(name = "assigned_by_instructor_id")
    private Instructor assignedBy;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;

}
