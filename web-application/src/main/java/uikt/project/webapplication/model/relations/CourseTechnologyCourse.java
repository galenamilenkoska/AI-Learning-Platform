package uikt.project.webapplication.model.relations;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.courses.Course;
import uikt.project.webapplication.model.entities.courses.CourseTechnology;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CourseTechnologyCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_technology_id")
    private CourseTechnology courseTechnology;
}
