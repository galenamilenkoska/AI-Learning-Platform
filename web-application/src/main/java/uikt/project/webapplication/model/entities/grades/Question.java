package com.example.ailearningplatform.model.entities.grades;


import com.example.ailearningplatform.model.entities.base.AttachableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Question extends AttachableEntity {

    @Column(nullable = false)
    private float points;

    @Column(name = "question_text", nullable = false)
    private String text;

    @Column(name = "question_order", nullable = false)
    private int order;

    @ManyToOne(optional = false)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;



}
