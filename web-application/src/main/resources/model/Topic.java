package uikt.ailearningplatform.webapp.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long topic_id;
    private String topic_name;
    @ManyToMany
    @JoinTable(name = "topic_has_category",
            joinColumns = @JoinColumn(name = "topic_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<TopicCategory> categories;

    public Topic() {
    }
}
