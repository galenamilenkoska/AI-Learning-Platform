package com.example.ailearningplatform.model.entities.grades;


import com.example.ailearningplatform.model.entities.users.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // A, B, C, D, E, F
    @Column(nullable = false)
    private Character grade;

    @Column(name = "date_graded")
    private LocalDate dateGraded;

    @ManyToOne(optional = false)
    //assigned to
    @JoinColumn(name = "student_id")
    private Student student;


}
