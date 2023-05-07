package uikt.project.webapplication.model.relations.location;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.base.Person;
import uikt.project.webapplication.model.entities.locations.Address;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PersonAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(optional = false)
    @JoinColumn(name = "address_id")
    private Address address;
}
