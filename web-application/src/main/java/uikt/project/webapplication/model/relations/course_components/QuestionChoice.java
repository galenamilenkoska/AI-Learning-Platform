package uikt.project.webapplication.model.relations.course_components;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.course_components.Choice;
import uikt.project.webapplication.model.entities.course_components.Question;

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
