package uikt.project.webapplication.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TopicCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long topic_cat_id;
    private String topic_cat_name;

    public TopicCategory() {
    }
}
