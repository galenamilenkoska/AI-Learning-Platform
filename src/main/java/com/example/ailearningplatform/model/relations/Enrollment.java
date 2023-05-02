package com.example.ailearningplatform.model.relations;


import com.example.ailearningplatform.model.entities.courses.Course;
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
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Course course;


    @Column(name = "enrollment_date", nullable = false)
    private LocalDate enrollmentDate;

}
