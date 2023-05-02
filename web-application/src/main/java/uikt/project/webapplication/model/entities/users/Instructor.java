package com.example.ailearningplatform.model.entities.users;


import com.example.ailearningplatform.model.entities.base.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Instructor  extends User {


    @Column(name = "teaching_experience")
    //In years
    private Integer teachingExperience;
}
