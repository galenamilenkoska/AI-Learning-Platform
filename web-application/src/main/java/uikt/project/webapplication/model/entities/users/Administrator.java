package uikt.project.webapplication.model.entities.users;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.base.User;

@Data
@Entity
@NoArgsConstructor
public class Administrator extends User {


}
