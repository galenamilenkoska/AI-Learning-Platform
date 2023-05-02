package uikt.project.webapplication.model.entities.locations;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(name = "street_name", nullable = false)
    private String streetName;

    @Column(name = "flat_number")
    private Integer flatNumber;


}
