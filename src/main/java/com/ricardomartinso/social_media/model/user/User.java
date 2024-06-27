package com.ricardomartinso.social_media.model.user;

import com.ricardomartinso.social_media.model.post.Post;
import com.ricardomartinso.social_media.model.post.PostLike;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_users")
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String lastName;

    @Column(nullable = false, unique = true)
    String username;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String password;

    @Column()
    Date createdAt = new Date();

    @Column()
    Date updatedAt = new Date();;

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

    @OneToMany
    private List<PostLike> postLikes;
}
