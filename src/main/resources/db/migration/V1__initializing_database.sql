CREATE TABLE tab_users (
                           id BIGSERIAL PRIMARY KEY,
                           first_name VARCHAR(255) NOT NULL,
                           last_name VARCHAR(255) NOT NULL,
                           username VARCHAR(255) NOT NULL UNIQUE,
                           email VARCHAR(255) NOT NULL UNIQUE,
                           password VARCHAR(255) NOT NULL,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tab_posts (
                       id BIGSERIAL PRIMARY KEY,
                       user_id BIGINT NOT NULL,
                       content TEXT,
                       image_url TEXT,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (user_id) REFERENCES tab_users(id) ON DELETE CASCADE
);

CREATE TABLE tab_post_likes (
                            id BIGSERIAL PRIMARY KEY,
                            user_id BIGINT NOT NULL,
                            post_id BIGINT NOT NULL,
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            FOREIGN KEY (user_id) REFERENCES tab_users(id) ON DELETE CASCADE,
                            FOREIGN KEY (post_id) REFERENCES tab_posts(id) ON DELETE CASCADE
);

CREATE TABLE tab_user_follows (
                              id BIGSERIAL PRIMARY KEY,
                              user_id BIGINT NOT NULL,
                              followed_user_id BIGINT NOT NULL,
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              FOREIGN KEY (user_id) REFERENCES tab_users(id) ON DELETE CASCADE,
                              FOREIGN KEY (followed_user_id) REFERENCES tab_users(id) ON DELETE CASCADE
);
