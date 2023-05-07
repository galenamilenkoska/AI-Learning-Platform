package uikt.project.webapplication.model.relations;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.courses.Course;
import uikt.project.webapplication.model.entities.courses.CourseCategory;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CourseCategoryCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_category_id")
    private CourseCategory courseCategory;

}
