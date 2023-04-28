package com.example.ailearningplatform.model.relations;

import com.example.ailearningplatform.model.entities.courses.Course;
import com.example.ailearningplatform.model.entities.courses.CourseDifficulty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDifficultyCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Course course;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private CourseDifficulty courseDifficulty;

}
