package uikt.project.webapplication.model.entities.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.base.User;

@Data
@Entity
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")

public class Administrator extends User {


}
