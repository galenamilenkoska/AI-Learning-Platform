package uikt.project.webapplication.model.relations;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.locations.Address;
import uikt.project.webapplication.model.entities.locations.City;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressCity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(optional = false)
    @JoinColumn(name = "city_id")
    private City city;
}
