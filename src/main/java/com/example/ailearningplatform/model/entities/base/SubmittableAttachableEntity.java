package com.example.ailearningplatform.model.entities.base;

import com.example.ailearningplatform.model.entities.grades.Grade;
import com.example.ailearningplatform.model.entities.users.Instructor;
import com.example.ailearningplatform.model.entities.users.Student;
import jakarta.annotation.sql.DataSourceDefinitions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmittableAttachableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "submission_date", nullable = false)
    private LocalDateTime submissionDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Student submittedBy;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Student assignedTo;

    @ManyToOne
    @JoinColumn(name = "id")
    private Instructor gradedBy;

    @ManyToOne
    @JoinColumn(name = "id")
    private Instructor assignedBy;

    @ManyToOne
    @JoinColumn(name = "id")
    private Grade grade;

    @Lob
    @Column(nullable = false)
    private byte [] content;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "mime_type")
    private String mimeType;


}
