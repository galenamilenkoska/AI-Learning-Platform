package uikt.project.webapplication.model.relations.forum;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.forum.Post;
import uikt.project.webapplication.model.entities.forum.Topic;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TopicPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToOne(optional = false)
    @JoinColumn(name = "post_id")
    private Post post;
}
