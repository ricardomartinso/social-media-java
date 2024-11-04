CREATE TABLE tab_token (
                           id BIGSERIAL PRIMARY KEY,
                           token VARCHAR(1024) UNIQUE NOT NULL,
                           token_type VARCHAR(255) NOT NULL CHECK (token_type IN ('BEARER', 'OTHER')),
                           revoked BOOLEAN NOT NULL,
                           expired BOOLEAN NOT NULL,
                           user_id BIGINT NOT NULL,
                           FOREIGN KEY (user_id) REFERENCES tab_users(id) ON DELETE CASCADE
);
