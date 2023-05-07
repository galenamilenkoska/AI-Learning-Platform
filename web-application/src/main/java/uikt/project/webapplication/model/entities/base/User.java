package uikt.project.webapplication.model.entities.base;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.enumerations.UserRole;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "\"user\"")
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
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


    public User(String username, String password, String email, LocalDate dateCreated, LocalDate dateUpdated, UserRole userRole, Person person) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.userRole = userRole;
        this.person = person;
    }
}
