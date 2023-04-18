package uikt.ailearningplatform.webapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long post_id;
    private String post_title;
    private String post_content;
    private LocalDateTime date_created;

    @ManyToOne
    private User user;
    @ManyToMany
    private List<Topic> topics;
    public Post() {
    }
}
