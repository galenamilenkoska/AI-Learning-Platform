package uikt.ailearningplatform.webapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CourseTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technology_id")
    private Long course_tech_id;
    private String course_tech_name;


    public CourseTechnology() {
    }
}
