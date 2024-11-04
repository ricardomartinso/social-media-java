-- Inserindo dados na tab_users somente se o usuário não existir (baseado no email ou username)
INSERT INTO tab_users (first_name, last_name, username, image_url, password, email)
SELECT 'John', 'Doe', 'johndoe', 'https://www.google.com/google.png', '12345', 'john@teste.com'
WHERE NOT EXISTS (
    SELECT 1 FROM tab_users WHERE email = 'john@teste.com' OR username = 'johndoe'
);

INSERT INTO tab_users (first_name, last_name, username, image_url, password, email)
SELECT 'Dominic', 'Silva', 'dominicsilva', 'https://www.google.com/google.png', '12345', 'dominicsilva@teste.com'
WHERE NOT EXISTS (
    SELECT 1 FROM tab_users WHERE email = 'dominicsilva@teste.com' OR username = 'dominicsilva'
);

INSERT INTO tab_users (first_name, last_name, username, image_url, password, email)
SELECT 'Carlos', 'Gutierrez', 'carlos', 'https://www.google.com/google.png', '12345', 'carlos@gutierrez.com'
WHERE NOT EXISTS (
    SELECT 1 FROM tab_users WHERE email = 'carlos@gutierrez.com' OR username = 'carlos'
);

-- Inserindo dados na tab_posts somente se o post não existir (baseado no conteúdo e user_id)
INSERT INTO tab_posts (content, image_url, created_at, user_id)
SELECT 'meu primeiro post John', 'http://www.google.com/jpg', CURRENT_TIMESTAMP, 1
WHERE NOT EXISTS (
    SELECT 1 FROM tab_posts WHERE content = 'meu primeiro post John' AND user_id = 1
);

INSERT INTO tab_posts (content, image_url, created_at, user_id)
SELECT 'meu primeiro post Doe', 'http://www.google.com/jpg', CURRENT_TIMESTAMP, 1
WHERE NOT EXISTS (
    SELECT 1 FROM tab_posts WHERE content = 'meu primeiro post Doe' AND user_id = 1
);

INSERT INTO tab_posts (content, image_url, created_at, user_id)
SELECT 'meu primeiro post johndoe', 'http://www.google.com/jpg', CURRENT_TIMESTAMP, 1
WHERE NOT EXISTS (
    SELECT 1 FROM tab_posts WHERE content = 'meu primeiro post johndoe' AND user_id = 1
);

INSERT INTO tab_posts (content, image_url, created_at, user_id)
SELECT 'meu primeiro post Dominic', 'http://www.google.com/jpg', CURRENT_TIMESTAMP, 2
WHERE NOT EXISTS (
    SELECT 1 FROM tab_posts WHERE content = 'meu primeiro post Dominic' AND user_id = 2
);

INSERT INTO tab_posts (content, image_url, created_at, user_id)
SELECT 'meu primeiro post Carlos', 'http://www.google.com/jpg', CURRENT_TIMESTAMP, 3
WHERE NOT EXISTS (
    SELECT 1 FROM tab_posts WHERE content = 'meu primeiro post Carlos' AND user_id = 3
);

-- Inserindo dados na tab_user_follows somente se a relação não existir (baseado em user_id e followed_user_id)
INSERT INTO tab_user_follows (user_id, followed_user_id)
SELECT 1, 2
WHERE NOT EXISTS (
    SELECT 1 FROM tab_user_follows WHERE user_id = 1 AND followed_user_id = 2
);

INSERT INTO tab_user_follows (user_id, followed_user_id)
SELECT 1, 3
WHERE NOT EXISTS (
    SELECT 1 FROM tab_user_follows WHERE user_id = 1 AND followed_user_id = 3
);

INSERT INTO tab_user_follows (user_id, followed_user_id)
SELECT 2, 1
WHERE NOT EXISTS (
    SELECT 1 FROM tab_user_follows WHERE user_id = 2 AND followed_user_id = 1
);

INSERT INTO tab_user_follows (user_id, followed_user_id)
SELECT 3, 1
WHERE NOT EXISTS (
    SELECT 1 FROM tab_user_follows WHERE user_id = 3 AND followed_user_id = 1
);

INSERT INTO tab_user_follows (user_id, followed_user_id)
SELECT 3, 2
WHERE NOT EXISTS (
    SELECT 1 FROM tab_user_follows WHERE user_id = 3 AND followed_user_id = 2
);

-- Inserindo dados na tab_post_comments somente se o comentário não existir (baseado no post_id, user_id e comentário)
INSERT INTO tab_post_comments (post_id, comment, user_id, created_at)
SELECT 1, 'Welcome to my post comments section', 1, CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM tab_post_comments WHERE post_id = 1 AND user_id = 1 AND comment = 'Welcome to my post comments section'
);

INSERT INTO tab_post_comments (post_id, comment, user_id, created_at)
SELECT 1, 'Good!', 2, CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM tab_post_comments WHERE post_id = 1 AND user_id = 2 AND comment = 'Good!'
);

INSERT INTO tab_post_comments (post_id, comment, user_id, created_at)
SELECT 1, 'Awesome!', 3, CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM tab_post_comments WHERE post_id = 1 AND user_id = 3 AND comment = 'Awesome!'
);

INSERT INTO tab_post_comments (post_id, comment, user_id, created_at)
SELECT 4, 'nice post', 1, CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM tab_post_comments WHERE post_id = 4 AND user_id = 1 AND comment = 'nice post'
);

INSERT INTO tab_post_comments (post_id, comment, user_id, created_at)
SELECT 4, 'Welcome to my post comment section', 2, CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM tab_post_comments WHERE post_id = 4 AND user_id = 2 AND comment = 'Welcome to my post comment section'
);

INSERT INTO tab_post_comments (post_id, comment, user_id, created_at)
SELECT 4, 'GJHF!', 3, CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM tab_post_comments WHERE post_id = 4 AND user_id = 3 AND comment = 'GJHF!'
);

-- Inserindo dados na tab_post_likes somente se a curtida não existir (baseado no post_id e user_id)
INSERT INTO tab_post_likes (post_id, user_id, created_at)
SELECT 1, 1, CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM tab_post_likes WHERE post_id = 1 AND user_id = 1
);

INSERT INTO tab_post_likes (post_id, user_id, created_at)
SELECT 1, 2, CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM tab_post_likes WHERE post_id = 1 AND user_id = 2
);

INSERT INTO tab_post_likes (post_id, user_id, created_at)
SELECT 1, 3, CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM tab_post_likes WHERE post_id = 1 AND user_id = 3
);

INSERT INTO tab_post_likes (post_id, user_id, created_at)
SELECT 4, 1, CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM tab_post_likes WHERE post_id = 4 AND user_id = 1
);

INSERT INTO tab_post_likes (post_id, user_id, created_at)
SELECT 4, 3, CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM tab_post_likes WHERE post_id = 4 AND user_id = 3
);
