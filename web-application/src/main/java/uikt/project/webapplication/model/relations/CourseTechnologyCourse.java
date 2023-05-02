package com.example.ailearningplatform.model.relations;

import com.example.ailearningplatform.model.entities.courses.Course;
import com.example.ailearningplatform.model.entities.courses.CourseTechnology;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CourseTechnologyCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Course course;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private CourseTechnology courseTechnology;
}
