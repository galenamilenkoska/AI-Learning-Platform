package uikt.project.webapplication.model.entities.courses;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.base.AttachableEntity;
import uikt.project.webapplication.model.entities.course_components.Quiz;

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
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToOne(optional = false)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @Override
    public int compareTo(Lecture o) {
        return Integer.compare(this.order, o.order);
    }
}
