package com.example.ailearningplatform.model.relations;

import com.example.ailearningplatform.model.entities.locations.Address;
import com.example.ailearningplatform.model.entities.base.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PersonAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Person person;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Address address;
}
