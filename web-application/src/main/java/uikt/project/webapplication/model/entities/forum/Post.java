package uikt.project.webapplication.model.entities.forum;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uikt.project.webapplication.model.entities.base.AttachableEntity;
import uikt.project.webapplication.model.entities.base.User;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post extends AttachableEntity {


    @Column(name = "post_timestamp", nullable = false)
    private LocalDateTime datePosted;

    @Column(name = "post_content", nullable = false, length = 500)
    private String text;

    @ManyToOne(optional = false)
    //author
    @JoinColumn(name = "user_id")
    private User user;









}
