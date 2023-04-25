package uikt.project.webapplication.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long country_id;
    private String country_name;


    public Country() {
    }
}
