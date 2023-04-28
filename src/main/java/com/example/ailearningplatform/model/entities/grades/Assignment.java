package com.example.ailearningplatform.model.entities.grades;


import com.example.ailearningplatform.model.entities.base.AttachableEntity;
import com.example.ailearningplatform.model.entities.base.SubmittableAttachableEntity;
import com.example.ailearningplatform.model.entities.base.SubmittableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assignment extends SubmittableAttachableEntity {

    @Column(name = "date_published", nullable = false)
    private LocalDate datePublished;

    @Column(nullable = false)
    private String title;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

}
