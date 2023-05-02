package uikt.project.webapplication.model.entities.base;


import jakarta.persistence.*;
import lombok.Data;
import uikt.project.webapplication.model.enumerations.UserRole;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name="date_created", nullable = false)
    private LocalDate dateCreated;

    @Column(name = "date_updated")
    private LocalDate dateUpdated;

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;


}
