
CREATE TABLE IF NOT EXISTS Categoria (
  idCategoria INT NOT NULL AUTO_INCREMENT,
  Categoria VARCHAR(45) NOT NULL,
  PRIMARY KEY (idCategoria))
ENGINE = InnoDB;

INSERT INTO categoria (categoria)
VALUES
  ("ut ipsum ac mi eleifend egestas. Sed pharetra, felis eget"),
  ("arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida"),
  ("Donec vitae erat vel pede blandit congue. In scelerisque scelerisque"),
  ("libero at auctor ullamcorper, nisl arcu iaculis enim, sit amet"),
  ("iaculis quis, pede. Praesent eu dui. Cum sociis natoque penatibus"),
  ("gravida mauris ut mi. Duis risus odio, auctor vitae, aliquet"),
  ("vitae dolor. Donec fringilla. Donec feugiat metus sit amet ante."),
  ("ac urna. Ut tincidunt vehicula risus. Nulla eget metus eu"),
  ("primis in faucibus orci luctus et ultrices posuere cubilia Curae"),
  ("Cras eget nisi dictum augue malesuada malesuada. Integer id magna");
  ("inceptos hymenaeos. Mauris ut quam vel sapien imperdiet ornare. In"),
  ("et risus. Quisque libero lacus, varius et, euismod et, commodo"),
  ("mi lorem, vehicula et, rutrum eu, ultrices sit amet, risus."),
  ("dolor elit, pellentesque a, facilisis non, bibendum sed, est. Nunc"),
  ("non, vestibulum nec, euismod in, dolor. Fusce feugiat. Lorem ipsum");

CREATE TABLE IF NOT EXISTS Usuario (
  idUsuario INT NOT NULL AUTO_INCREMENT,
  Nome VARCHAR(45) NOT NULL,
  Email VARCHAR(45) NOT NULL,
  PRIMARY KEY (idUsuario))
ENGINE = InnoDB;

INSERT INTO Usuario (nome,email)
VALUES
  ("Kareem Summers","sodales@aol.com"),
  ("Cullen Ellison","dictum.eu@protonmail.ca"),
  ("Patricia Pope","ornare.lectus.justo@protonmail.net"),
  ("Finn Moran","sem.mollis@yahoo.org"),
  ("Thaddeus Mclean","sed.eu.eros@icloud.org"),
  ("Tad Mercer","nunc.id.enim@outlook.org"),
  ("Callie Brown","a@yahoo.couk"),
  ("Solomon Brown","aliquam.enim@aol.com"),
  ("Tasha Brewer","auctor.velit@outlook.couk"),
  ("Erasmus Perry","integer.aliquam.adipiscing@protonmail.couk");

CREATE TABLE IF NOT EXISTS Produto (
  idProduto INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  Preço DOUBLE NOT NULL,
  idCategoriaProduto INT NOT NULL,
  idVendedor INT NOT NULL,
  PRIMARY KEY (idProduto),
  CONSTRAINT idCategoriaProduto
    FOREIGN KEY (idCategoriaProduto)
    REFERENCES Categoria (idCategoria)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT idVendedor
    FOREIGN KEY (idVendedor)
    REFERENCES Usuario (idUsuario)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

INSERT INTO produto (nome,preco,idCategoriaProduto,idVendedor)
VALUES
  ("eu",47,8,7),
  ("magna.",386,11,3),
  ("id,",780,1,8),
  ("elit,",298,3,5),
  ("cursus,",718,14,9),
  ("Pellentesque",142,1,7),
  ("nulla.",496,5,7),
  ("euismod",990,14,8),
  ("nulla",745,12,3),
  ("nisi",690,7,6),
  ("Proin",618,1,6),
  ("lacinia",930,14,0),
  ("Curabitur",677,2,8),
  ("ipsum",384,8,6),
  ("scelerisque",839,10,1),
  ("elit.",277,14,3),
  ("lorem",38,13,9),
  ("eu",574,4,5),
  ("aliquet",690,8,6),
  ("netus",791,5,7);

CREATE TABLE IF NOT EXISTS Pedido (
  idPedido INT NOT NULL,
  idUsuarioPedido INT NOT NULL,
  PRIMARY KEY (idPedido), 
  CONSTRAINT idUsuarioPedido
    FOREIGN KEY (idUsuarioPedido)
    REFERENCES Usuario (idUsuario)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS FotoProduto (
  idFotoProduto INT NOT NULL AUTO_INCREMENT,
  Url VARCHAR(500) NOT NULL,
  idProdutoFoto INT NOT NULL,
  PRIMARY KEY (idFotoProduto),
  CONSTRAINT idProdutoFoto
    FOREIGN KEY (idProdutoFoto)
    REFERENCES Produto (idProduto)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS ProdutoPedido (
  idProdutoPedido INT NOT NULL AUTO_INCREMENT,
  idProdutoPP INT NOT NULL,
  idPedidoPP INT NOT NULL,
  PRIMARY KEY (idProdutoPedido),
  CONSTRAINT idProdutoPP
    FOREIGN KEY (idProdutoPP)
    REFERENCES Produto (idProduto)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT idPedidoPP
    FOREIGN KEY (idPedidoPP)
    REFERENCES Pedido (idPedido)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Lance (
  idLance INT NOT NULL AUTO_INCREMENT,
  Valor DOUBLE NOT NULL,
  idProdutoLance INT NOT NULL,
  idSolicitante INT NOT NULL,
  status TINYINT NOT NULL,
  PRIMARY KEY (idLance),
  CONSTRAINT idProdutoLance
    FOREIGN KEY (idProdutoLance)
    REFERENCES Produto (idProduto)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT idSolicitante
    FOREIGN KEY (idSolicitante)
    REFERENCES Usuario (idUsuario)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Caracteristicas (
  idCaracteristicas INT NOT NULL AUTO_INCREMENT,
  Caracteristica VARCHAR(45) NOT NULL,
  idProdutoCarac INT NOT NULL,
  PRIMARY KEY (idCaracteristicas),
  CONSTRAINT idProdutoCarac
    FOREIGN KEY (idProdutoCarac)
    REFERENCES Produto (idProduto)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Amizade (
  idAmizade INT UNSIGNED NOT NULL,
  idRemetente INT NOT NULL,
  idDestinatario INT NOT NULL,
  PRIMARY KEY (idAmizade),
  CONSTRAINT idRemetente
    FOREIGN KEY (idRemetente)
    REFERENCES Usuario (idUsuario)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT idDestinatario
    FOREIGN KEY (idDestinatario)
    REFERENCES Usuario (idUsuario)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;
