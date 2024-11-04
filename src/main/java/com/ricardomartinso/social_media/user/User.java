package com.ricardomartinso.social_media.user;

import com.ricardomartinso.social_media.auth.RegisterRequest;
import com.ricardomartinso.social_media.post.Post;
import com.ricardomartinso.social_media.post.PostLike;
import com.ricardomartinso.social_media.token.Token;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tab_users")
@Entity
public class User {

    public User(RegisterRequest newUser, String encryptedPassword) {
        this.username = newUser.username();
        this.password = encryptedPassword;
        this.email = newUser.email();
        this.firstName = newUser.first_name();
        this.lastName = newUser.last_name();
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = true, unique = false)
    private String imageUrl;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    private Set<PostLike> postLikes;

    @OneToMany(mappedBy = "user")
    private Set<UserFollow> follows;

    @OneToMany(mappedBy = "followedUser")
    private Set<UserFollow> followers;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @Column(name = "created_at")
    private Date createdAt = new Date();

    @Column(name = "updated_at")
    private Date updatedAt = new Date();

}
