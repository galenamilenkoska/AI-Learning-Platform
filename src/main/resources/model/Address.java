package uikt.ailearningplatform.webapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long address_id;
    private String street;
    private Integer flat_number;


    public Address() {
    }
}
