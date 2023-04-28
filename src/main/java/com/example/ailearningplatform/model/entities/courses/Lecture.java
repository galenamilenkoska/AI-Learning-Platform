package com.example.ailearningplatform.model.entities.courses;


import com.example.ailearningplatform.model.entities.base.AttachableEntity;
import com.example.ailearningplatform.model.entities.grades.Quiz;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Lecture extends AttachableEntity implements Comparable<Lecture>{


    @Column(name = "lecture_title", nullable = false)
    private String title;

    @Column(name = "lecture_description", nullable = false)
    private String description;

    @Column(name = "lecture_order")
    private int order;

    @Column(name = "mark_completed")
    private boolean isCompleted;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Course course;

    @OneToOne(optional = false)
    @JoinColumn(name = "id")
    private Quiz quiz;

    @Override
    public int compareTo(Lecture o) {
        return Integer.compare(this.order, o.order);
    }
}
