package com.example.ailearningplatform.model.entities.base;

import com.example.ailearningplatform.model.enumerations.UserRole;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name="date_created", nullable = false)
    private LocalDate dateCreated;

    @Column(name = "date_updated")
    private LocalDate dateUpdated;

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @OneToOne
    @JoinColumn(name = "id")
    private Person person;


}
