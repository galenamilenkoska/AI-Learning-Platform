package uikt.project.webapplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="Student")
public class Student extends User{


    @Column(name="student_id")
    private Long student_id;

    @OneToMany(mappedBy="student")
    private List<StudentCourse> studentCourses;
    public Student() {
    }
}
