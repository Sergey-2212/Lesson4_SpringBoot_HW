DROP TABLE if exists products;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), cost DOUBLE PRECISION);
INSERT INTO products (title, cost) VALUES ('Apples', 123.0), ('Chocolate Bar', 99.5), ('Milk', 110.7);