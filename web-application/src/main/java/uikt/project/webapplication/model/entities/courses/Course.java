package uikt.project.webapplication.model.entities.courses;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.base.AttachableEntity;
import uikt.project.webapplication.model.entities.users.Administrator;
import uikt.project.webapplication.model.entities.users.Instructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Course extends AttachableEntity {


    @Column(name = "course_name", unique = true, nullable = false)
    private String name;

    @Column(name = "course_description", nullable = false)
    private String description;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "administrator_id")
    private Administrator createdBy;

    @ManyToOne(optional = false)
    @JoinColumn(name = "instructor_id")
    private Instructor taughtBy;


}
