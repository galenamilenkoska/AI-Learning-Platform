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
public class Choice extends AttachableEntity {


    @Column(name = "choice_text", nullable = false)
    private String text;

    @Column(name = "is_correct")
    private boolean isCorrect;


}
