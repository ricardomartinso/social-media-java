
INSERT INTO tab_users (id, first_name, last_name, username, password, email) VALUES (1, 'John', 'Doe', 'johndoe', '12345', 'john@teste.com');
INSERT INTO tab_users (id, first_name, last_name, username, password, email) VALUES (2, 'Dominic', 'Silva', 'dominicsilva', '12345', 'dominicsilva@teste.com');
INSERT INTO tab_users (id, first_name, last_name, username, password, email) VALUES (3, 'Carlos', 'Gutierrez', 'carlos', '12345', 'carlos@gutierrez.com');


INSERT INTO tab_posts (id, content, image_url, created_at, user_id) VALUES (1, 'meu primeiro post ricardomartins', 'http://www.google.com/jpg', CURRENT_TIMESTAMP, 1);
INSERT INTO tab_posts (id, content, image_url, created_at, user_id) VALUES (2, 'meu primeiro post caroli23', 'http://www.google.com/jpg', CURRENT_TIMESTAMP, 2);
INSERT INTO tab_posts (id, content, image_url, created_at, user_id) VALUES (3, 'meu primeiro post tashiro', 'http://www.google.com/jpg', CURRENT_TIMESTAMP, 3);


INSERT INTO tab_user_follows (id, user_id, followed_user_id) VALUES (1, 1, 2); -- John seguindo Dominic
INSERT INTO tab_user_follows (id, user_id, followed_user_id) VALUES (2, 1, 3); -- John seguindo Carlos

INSERT INTO tab_user_follows (id, user_id, followed_user_id) VALUES (3, 2, 1); -- Dominic seguindo John

INSERT INTO tab_user_follows (id, user_id, followed_user_id) VALUES (4, 3, 1); -- Carlos seguindo John
INSERT INTO tab_user_follows (id, user_id, followed_user_id) VALUES (5, 3, 2); -- Carlos seguindo Dominic
