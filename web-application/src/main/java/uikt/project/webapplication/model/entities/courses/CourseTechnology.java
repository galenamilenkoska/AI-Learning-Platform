package com.example.ailearningplatform.model.entities.courses;


import com.example.ailearningplatform.model.entities.base.AttachableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseTechnology extends AttachableEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

}
