package uikt.project.webapplication.model.entities.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.base.User;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")

public class Instructor  extends User {


    @Column(name = "teaching_experience")
    //In years
    private Integer teachingExperience;
}
