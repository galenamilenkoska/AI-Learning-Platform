package uikt.project.webapplication.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Administrator extends User{


    public Administrator() {
    }
}
