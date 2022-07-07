DROP TABLE valores;

CREATE TABLE valores(
    id serial primary key,
    a float,
    b float,
    c float,
    x float,
    y float
);

INSERT INTO valores VALUES (0,0,0,0,0,0);

SELECT * FROM valores;

SELECT * FROM valores ORDER BY id DESC;

SELECT * FROM valores ORDER BY id DESC limit 1;
