package uikt.ailearningplatform.webapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CourseCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long course_cat_id;
    private String course_cat_name;


    public CourseCategory() {
    }
}
