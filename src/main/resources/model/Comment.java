package uikt.ailearningplatform.webapp.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long comment_id;
    private String comment_content;
    private LocalDateTime date_created;
    @ManyToOne
    private Post post;
    @ManyToOne
    private User user;

    public Comment() {
    }
}
