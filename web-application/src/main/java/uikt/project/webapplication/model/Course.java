package uikt.project.webapplication.model;

import jakarta.persistence.*;
import lombok.Data;
import uikt.project.webapplication.enumerations.LevelDifficulty;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_id")
    private Long course_id;
    private String course_name;
    private String course_description;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private String imgUrl;
    
    @Enumerated(EnumType.STRING)
    private LevelDifficulty levelDifficulty;

    @ManyToMany
    @JoinTable(name = "course_belongs_to_category",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CourseCategory> categories;

    @ManyToMany
    @JoinTable(name = "course_uses_technology",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id"))
    private List<CourseTechnology> technologies;

    @OneToMany(mappedBy="course")
    private List<StudentCourse> studentCourses;
    @ManyToOne
    private Administrator created_by;

    /*
       duration_in_hours
     */
    public Course() {
    }
}
