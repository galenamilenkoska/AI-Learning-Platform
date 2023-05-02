package uikt.project.webapplication.model.relations;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.forum.Topic;
import uikt.project.webapplication.model.entities.forum.TopicCategory;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicCategoryTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToOne(optional = false)
    @JoinColumn(name = "topic_category_id")
    private TopicCategory topicCategory;
}
