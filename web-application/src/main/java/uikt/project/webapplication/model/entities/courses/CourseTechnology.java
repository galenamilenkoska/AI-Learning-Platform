package uikt.project.webapplication.model.entities.courses;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.base.AttachableEntity;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseTechnology extends AttachableEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

}
