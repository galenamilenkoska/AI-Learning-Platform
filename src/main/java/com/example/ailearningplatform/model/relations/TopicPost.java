package com.example.ailearningplatform.model.relations;

import com.example.ailearningplatform.model.entities.forum.Post;
import com.example.ailearningplatform.model.entities.forum.Topic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TopicPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Topic topic;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id")
    private Post post;
}
