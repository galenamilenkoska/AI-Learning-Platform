package uikt.project.webapplication.model.relations.courses;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.courses.Course;
import uikt.project.webapplication.model.entities.courses.CourseDifficulty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDifficultyCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_difficulty_id")
    private CourseDifficulty courseDifficulty;

}
