package com.example.ailearningplatform.model.relations;

import com.example.ailearningplatform.model.entities.locations.City;
import com.example.ailearningplatform.model.entities.locations.Country;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CityCountry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private City city;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Country country;
}
