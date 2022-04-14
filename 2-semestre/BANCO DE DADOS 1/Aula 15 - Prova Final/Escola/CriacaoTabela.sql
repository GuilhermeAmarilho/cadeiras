
CREATE TABLE tipocurso (
  idtipocurso INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NULL,
  PRIMARY KEY (idtipocurso));

CREATE TABLE curso (
  idcurso INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NULL,
  idtipocurso INT NULL,
  PRIMARY KEY (idcurso),
  CONSTRAINT idtipocurso_curso
    FOREIGN KEY (idtipocurso)
    REFERENCES tipocurso (idtipocurso)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE turma (
  idturma INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NULL,
  ano INT NULL,
  idcurso INT NULL,
  PRIMARY KEY (idturma),
  CONSTRAINT idcurso_turma
    FOREIGN KEY (idcurso)
    REFERENCES curso (idcurso)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE aluno (
  idaluno INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(300) NULL,
  email VARCHAR(300) NULL,
  data_nascimento DATETIME NULL,
  cpf VARCHAR(15) NULL,
  idturma INT NULL,
  PRIMARY KEY (idaluno),
  CONSTRAINT idturma_aluno
    FOREIGN KEY (idturma)
    REFERENCES turma (idturma)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE disciplina (
  iddisciplina INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(150) NULL,
  idturma INT NULL,
  qtdavaliacoes INT NULL,
  PRIMARY KEY (iddisciplina),
  CONSTRAINT idturma_disciplina
    FOREIGN KEY (idturma)
    REFERENCES turma (idturma)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE avalicao (
  idavalicao INT NOT NULL,
  nome VARCHAR(300) NULL,
  iddisciplina INT NULL,
  data DATE NULL,
  PRIMARY KEY (idavalicao),
  CONSTRAINT iddisciplina_avaliacao
    FOREIGN KEY (iddisciplina)
    REFERENCES disciplina (iddisciplina)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE nota (
  idnota INT NOT NULL AUTO_INCREMENT,
  idaluno INT NULL,
  idavaliacao INT NULL,
  valor FLOAT NULL,
  PRIMARY KEY (idnota),
  CONSTRAINT idaluno_nota
    FOREIGN KEY (idaluno)
    REFERENCES aluno (idaluno)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT idavaliacao_nota
    FOREIGN KEY (idavaliacao)
    REFERENCES avalicao (idavalicao)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE notificacao (
  idnotificacao INT NOT NULL AUTO_INCREMENT,
  idaluno INT NULL,
  texto VARCHAR(300) NULL,
  data_leitura DATETIME NULL,
  PRIMARY KEY (idnotificacao),
  CONSTRAINT idaluno_notificacao
    FOREIGN KEY (idnotificacao)
    REFERENCES aluno (idaluno)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

