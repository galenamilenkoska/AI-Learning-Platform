package com.example.ailearningplatform.model.relations;


import com.example.ailearningplatform.model.entities.grades.Question;
import com.example.ailearningplatform.model.entities.grades.Quiz;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizQuesiton {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizQuestionId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Quiz quiz;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Question question;
}
