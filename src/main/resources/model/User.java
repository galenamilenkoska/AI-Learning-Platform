package uikt.ailearningplatform.webapp.model;

import jakarta.persistence.*;
import lombok.Data;
import uikt.ailearningplatform.webapp.enumerations.Role;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="app_user")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class User {

    @Id
    @Column(name="id")
    private String username;

    private String password;

    private String name;

    private String surname;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne
    private Person person;

    public User() {
    }
}
