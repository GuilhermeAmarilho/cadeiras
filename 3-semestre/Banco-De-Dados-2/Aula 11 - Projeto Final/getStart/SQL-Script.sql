drop table compra;
drop table produto;
drop table categoria;
drop table usuario;

CREATE TABLE usuario(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    saldo FLOAT NOT NULL
);

INSERT INTO usuario (nome, email, senha, tipo, saldo) VALUES
    ('admin', 'admin', md5('admin'), 'admin', 120.99);

CREATE TABLE categoria (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

INSERT INTO categoria (nome) VALUES ('salgados'),('doces'),('lanches'),('refeições'),('bebidas');

CREATE TABLE produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    preco FLOAT NOT NULL,
    categoria INT NOT NULL,
    CONSTRAINT fkcategoria
        FOREIGN KEY(categoria) 
        REFERENCES categoria(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

INSERT INTO produto (nome, preco, categoria) VALUES ('Coxinha', 4.99, 1), ('Risoles', 4.99,1), ('Croquete', 4.99, 1), ('Espetinho', 2.99, 1), ('Brigadeiro', 3.99, 2), ('Cookie', 1.99, 2),  ('Muffin', 6.99, 2), ('Bombom', 0.99, 2), ('Xis tudo', 19.99, 3), ('Xis salada', 14.99, 3), ('Misto quente', 9.99, 3),  ('Bauru', 24.99, 3), ('A la minuta', 24.99, 4), ('Bife a parmegiana', 26.99, 4), ('Bisteca de porco', 28.99, 4), ('Torre de batata', 39.99, 4), ('Coca cola 2l', 7.99, 5), ('Fanta 2l', 7.99, 5), ('Água c/ gás 500ml', 1.99, 5), ('Suco del valle 500ml', 2.99, 5);

CREATE TABLE compra(
    id SERIAL PRIMARY KEY,
    usuario INT NOT NULL,
    produto INT NOT NULL,
    CONSTRAINT fkusuario
        FOREIGN KEY(usuario) 
        REFERENCES usuario(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fkproduto
        FOREIGN KEY(produto) 
        REFERENCES produto(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

