package uikt.project.webapplication.model.entities.grades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.base.AttachableEntity;
import uikt.project.webapplication.model.entities.users.Instructor;
import uikt.project.webapplication.model.entities.users.Student;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Certificate extends AttachableEntity {


    @ManyToOne(optional = false)
    //received by
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(optional = false)
    //granted by
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

}
