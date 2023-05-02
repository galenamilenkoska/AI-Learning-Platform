package com.example.ailearningplatform.model.relations;


import com.example.ailearningplatform.model.entities.grades.Choice;
import com.example.ailearningplatform.model.entities.grades.Question;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionChoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionChoiceId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Question question;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Choice choice;

}
