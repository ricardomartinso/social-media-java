package com.ricardomartinso.social_media.model.post;

import com.ricardomartinso.social_media.model.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "tab_posts")
@Entity
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String text;

    @Column
    private String imageUrl;

    @Column
    private Long likes;


    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostComment> comments;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user_id;

}
