
INSERT INTO tab_users (first_name, last_name, username, image_url, password, email) VALUES ('John', 'Doe', 'johndoe', 'https://www.google.com/google.png', '12345', 'john@teste.com');
INSERT INTO tab_users (first_name, last_name, username, image_url, password, email) VALUES ('Dominic', 'Silva', 'dominicsilva', 'https://www.google.com/google.png','12345', 'dominicsilva@teste.com');
INSERT INTO tab_users (first_name, last_name, username, image_url, password, email) VALUES ('Carlos', 'Gutierrez', 'carlos', 'https://www.google.com/google.png', '12345', 'carlos@gutierrez.com');


INSERT INTO tab_posts (content, image_url, created_at, user_id) VALUES ('meu primeiro post John', 'http://www.google.com/jpg', CURRENT_TIMESTAMP, 1);
INSERT INTO tab_posts (content, image_url, created_at, user_id) VALUES ('meu primeiro post Doe', 'http://www.google.com/jpg', CURRENT_TIMESTAMP, 1);
INSERT INTO tab_posts (content, image_url, created_at, user_id) VALUES ('meu primeiro post johndoe', 'http://www.google.com/jpg', CURRENT_TIMESTAMP, 1);

INSERT INTO tab_posts (content, image_url, created_at, user_id) VALUES ('meu primeiro post Dominic', 'http://www.google.com/jpg', CURRENT_TIMESTAMP, 2);
INSERT INTO tab_posts (content, image_url, created_at, user_id) VALUES ('meu primeiro post Carlos', 'http://www.google.com/jpg', CURRENT_TIMESTAMP, 3);


INSERT INTO tab_user_follows (user_id, followed_user_id) VALUES (1, 2); -- John seguindo Dominic
INSERT INTO tab_user_follows (user_id, followed_user_id) VALUES (1, 3); -- John seguindo Carlos

INSERT INTO tab_user_follows (user_id, followed_user_id) VALUES (2, 1); -- Dominic seguindo John

INSERT INTO tab_user_follows (user_id, followed_user_id) VALUES (3, 1); -- Carlos seguindo John
INSERT INTO tab_user_follows (user_id, followed_user_id) VALUES (3, 2); -- Carlos seguindo Dominic

INSERT INTO tab_post_comments (post_id, comment, user_id, created_at) VALUES (1, 'Welcome to my post comments section', 1, CURRENT_TIMESTAMP);
INSERT INTO tab_post_comments (post_id, comment, user_id, created_at) VALUES (1, 'Good!', 2, CURRENT_TIMESTAMP);
INSERT INTO tab_post_comments (post_id, comment, user_id, created_at) VALUES (1, 'Awesome!', 3, CURRENT_TIMESTAMP);

INSERT INTO tab_post_comments (post_id, comment, user_id, created_at) VALUES (4, 'nice post', 1, CURRENT_TIMESTAMP);
INSERT INTO tab_post_comments (post_id, comment, user_id, created_at) VALUES (4, 'Welcome to my post comment section', 2, CURRENT_TIMESTAMP);
INSERT INTO tab_post_comments (post_id, comment, user_id, created_at) VALUES (4, 'GJHF!', 3, CURRENT_TIMESTAMP);

INSERT INTO tab_post_likes (post_id, user_id, created_at) VALUES (1, 1, CURRENT_TIMESTAMP);
INSERT INTO tab_post_likes (post_id, user_id, created_at) VALUES (1, 2, CURRENT_TIMESTAMP);
INSERT INTO tab_post_likes (post_id, user_id, created_at) VALUES (1, 3, CURRENT_TIMESTAMP);


INSERT INTO tab_post_likes (post_id, user_id, created_at) VALUES (4, 1, CURRENT_TIMESTAMP);
INSERT INTO tab_post_likes (post_id, user_id, created_at) VALUES (4, 3, CURRENT_TIMESTAMP);
