package uikt.project.webapplication.model.entities.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.base.Person;
import uikt.project.webapplication.model.entities.base.User;
import uikt.project.webapplication.model.enumerations.UserRole;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User {




    public Student(String username, String password, String email, LocalDate dateCreated, LocalDate dateUpdated, UserRole userRole, Person person) {
        super(username, password, email, dateCreated, dateUpdated, userRole, person);
    }
}
