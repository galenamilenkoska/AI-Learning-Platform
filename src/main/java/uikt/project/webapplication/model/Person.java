package uikt.project.webapplication.model;

import jakarta.persistence.*;
import lombok.Data;
import uikt.project.webapplication.enumerations.AcademicStatus;


import java.time.LocalDateTime;

@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long person_id;
    private String first_name;
    private String middle_name;
    private String last_name;

    private LocalDateTime date_of_birth;
    private String phone_number;

    @Enumerated(EnumType.STRING)
    private AcademicStatus academicStatus;

    public Person() {
    }
}
