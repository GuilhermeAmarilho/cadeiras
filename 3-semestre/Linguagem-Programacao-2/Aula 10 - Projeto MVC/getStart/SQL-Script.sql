CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cargo VARCHAR(100) NOT NULL
);

insert into users (nome, cargo) values 
    ('Guilherme', 'Desenvolvedor'), 
    ('João','Designer'), 
    ('Gabrielle','Engenheiro'), 
    ('Adrian','RH');


CREATE TABLE projects (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    descricao VARCHAR(2000) NOT NULL
);

INSERT INTO projects (titulo, descricao) VALUES
    ('Projeto MVC', 'Projeto de Linguagem de programação 2 feito em php usando o padrão MVC'),
    ('Projeto POO', 'Projeto de Paradigmas da computação feito em JavaScript usando Objetos'),
    ('Projeto JDB', 'Projeto de Linguagem de programação 1 feito em Java usando banco de dados'),
    ('Projeto HomePage', 'Projeto de WebDesign feito em HTML 5 + CSS 3 usando padrões UI UX');
    