INSERT INTO publisher(id, name) VALUES (1, 'PWN'), (2, 'Ossolineum'), (3, 'Helion');
INSERT INTO author(id,name,lastName) VALUES (1,'Bolesław','Prus');
INSERT INTO category(id, name) VALUES (1, 'IT');

INSERT INTO books(id, title, rating, description, publisher_id, pages, author_id, category_id) VALUES (1, 'O Javie', 7, 'Thinking in Java', 3, 1, 1, 1);
INSERT INTO books(id, title, rating, description, publisher_id, pages, author_id, category_id) VALUES (2, 'O C++', 8, 'Thinking in C++', 3, 1, 1, 1);
INSERT INTO books(id, title, rating, description, publisher_id, pages, author_id, category_id) VALUES (3, 'Dobra powiesc', 8, 'W pustyni i w puszczy', 2, 1, 1, 1);