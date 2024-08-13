package com.ricardomartinso.social_media.model.post;

import com.ricardomartinso.social_media.model.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tab_post_comments")
@Data
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    private String comment;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private Date createdAt = new Date();
}
