package uikt.project.webapplication.model.relations;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.grades.Choice;
import uikt.project.webapplication.model.entities.grades.Question;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionChoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne(optional = false)
    @JoinColumn(name = "choice_id")
    private Choice choice;

}
