package com.example.ailearningplatform.model.relations;


import com.example.ailearningplatform.model.entities.locations.Address;
import com.example.ailearningplatform.model.entities.locations.City;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressCity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Address address;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private City city;
}
