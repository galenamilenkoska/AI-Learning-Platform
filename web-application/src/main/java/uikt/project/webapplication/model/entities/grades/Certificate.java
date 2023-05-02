package com.example.ailearningplatform.model.entities.grades;

import com.example.ailearningplatform.model.entities.base.AttachableEntity;
import com.example.ailearningplatform.model.entities.users.Instructor;
import com.example.ailearningplatform.model.entities.users.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Certificate extends AttachableEntity {


    @ManyToOne(optional = false)
    //received by
    @JoinColumn(name = "id")
    private Student student;

    @ManyToOne(optional = false)
    //granted by
    @JoinColumn(name = "id")
    private Instructor instructor;

}
