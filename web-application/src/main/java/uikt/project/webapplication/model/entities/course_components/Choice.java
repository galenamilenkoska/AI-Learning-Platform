package uikt.project.webapplication.model.entities.course_components;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.base.AttachableEntity;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Choice extends AttachableEntity {


    @Column(name = "choice_text", nullable = false)
    private String text;

    @Column(name = "is_correct")
    private boolean isCorrect;


}
