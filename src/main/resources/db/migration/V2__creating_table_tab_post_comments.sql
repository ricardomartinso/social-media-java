CREATE TABLE tab_post_comments (
                                   id BIGSERIAL PRIMARY KEY,
                                   post_id BIGINT NOT NULL,
                                   comment TEXT,
                                   user_id BIGINT,
                                   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                   CONSTRAINT fk_post FOREIGN KEY (post_id) REFERENCES tab_posts(id),
                                   CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES tab_users(id)
);
