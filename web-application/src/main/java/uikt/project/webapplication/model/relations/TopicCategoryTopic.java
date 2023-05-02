package com.example.ailearningplatform.model.relations;

import com.example.ailearningplatform.model.entities.forum.Topic;
import com.example.ailearningplatform.model.entities.forum.TopicCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicCategoryTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Topic topic;

    @ManyToOne(optional = false)
    @JoinColumn(name = "topic_cateogry_id")
    private TopicCategory topicCategory;
}
