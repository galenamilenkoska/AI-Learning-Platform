package com.example.ailearningplatform.model.entities.forum;

import com.example.ailearningplatform.model.entities.base.AttachableEntity;
import com.example.ailearningplatform.model.entities.base.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
