package uikt.project.webapplication.model.relations;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.locations.City;
import uikt.project.webapplication.model.entities.locations.Country;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CityCountry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id")
    private Country country;
}
