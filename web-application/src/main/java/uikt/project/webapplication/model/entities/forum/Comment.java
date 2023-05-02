package com.example.ailearningplatform.model.entities.forum;


import com.example.ailearningplatform.model.entities.base.AttachableEntity;
import com.example.ailearningplatform.model.entities.base.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends AttachableEntity {


    @Column(name = "comment_timestamp", nullable = false)
    private LocalDate datePosted;

    @Column(name = "comment_content", nullable = false, length = 500)
    private String text;

    @ManyToOne(optional = false)
    //author
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "post_id")
    private Post post;




}
