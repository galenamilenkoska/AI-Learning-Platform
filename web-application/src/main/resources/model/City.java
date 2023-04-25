package uikt.ailearningplatform.webapp.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long city_id;
    private String city_name;
    private String postal_code;

    @ManyToMany
    private List<Address> addresses;
    @ManyToOne
    private Country country;

    public City() {
    }
}
