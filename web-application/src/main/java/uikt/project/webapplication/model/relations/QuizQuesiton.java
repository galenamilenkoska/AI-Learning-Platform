package uikt.project.webapplication.model.relations;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.grades.Question;
import uikt.project.webapplication.model.entities.grades.Quiz;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizQuesiton {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @ManyToOne(optional = false)
    @JoinColumn(name = "question_id")
    private Question question;
}
