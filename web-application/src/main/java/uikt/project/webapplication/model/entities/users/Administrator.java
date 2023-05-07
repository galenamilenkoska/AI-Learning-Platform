package uikt.project.webapplication.model.entities.users;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.base.User;


import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Administrator extends User {

}
