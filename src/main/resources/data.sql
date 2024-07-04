
INSERT INTO tab_users (first_name, last_name, username, password, email) VALUES ('John', 'Doe', 'johndoe', '12345', 'john@teste.com');
INSERT INTO tab_users (first_name, last_name, username, password, email) VALUES ('Dominic', 'Silva', 'dominicsilva', '12345', 'dominicsilva@teste.com');
INSERT INTO tab_users (first_name, last_name, username, password, email) VALUES ('Carlos', 'Gutierrez', 'carlos', '12345', 'carlos@gutierrez.com');


INSERT INTO tab_posts (content, image_url, created_at, user_id) VALUES ('meu primeiro post John', 'http://www.google.com/jpg', CURRENT_TIMESTAMP, 1);
INSERT INTO tab_posts (content, image_url, created_at, user_id) VALUES ('meu primeiro post Doe', 'http://www.google.com/jpg', CURRENT_TIMESTAMP, 1);
INSERT INTO tab_posts (content, image_url, created_at, user_id) VALUES ('meu primeiro post johndoe', 'http://www.google.com/jpg', CURRENT_TIMESTAMP, 1);

INSERT INTO tab_posts (content, image_url, created_at, user_id) VALUES ('meu primeiro post Dominic', 'http://www.google.com/jpg', CURRENT_TIMESTAMP, 2);
INSERT INTO tab_posts (content, image_url, created_at, user_id) VALUES ('meu primeiro post Carlos', 'http://www.google.com/jpg', CURRENT_TIMESTAMP, 3);


INSERT INTO tab_user_follows (user_id, followed_user_id) VALUES ( 1, 2); -- John seguindo Dominic
INSERT INTO tab_user_follows (user_id, followed_user_id) VALUES ( 1, 3); -- John seguindo Carlos

INSERT INTO tab_user_follows (user_id, followed_user_id) VALUES ( 2, 1); -- Dominic seguindo John

INSERT INTO tab_user_follows (user_id, followed_user_id) VALUES (3, 1); -- Carlos seguindo John
INSERT INTO tab_user_follows (user_id, followed_user_id) VALUES (3, 2); -- Carlos seguindo Dominic
