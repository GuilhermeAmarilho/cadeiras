-- MySQL Script generated by MySQL Workbench
-- Wed Dec  1 09:59:24 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`usuario` ;

CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(90) NOT NULL,
  `datanascimento` DATETIME NOT NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`professor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`professor` ;

CREATE TABLE IF NOT EXISTS `mydb`.`professor` (
  `idprofessor` INT NOT NULL AUTO_INCREMENT,
  `idusuario` INT NOT NULL,
  `precohora` FLOAT NOT NULL,
  PRIMARY KEY (`idprofessor`),
  INDEX `idusuario_idx` (`idusuario` ASC) VISIBLE,
  CONSTRAINT `idusuario`
    FOREIGN KEY (`idusuario`)
    REFERENCES `mydb`.`usuario` (`idusuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`fotoprofessor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`fotoprofessor` ;

CREATE TABLE IF NOT EXISTS `mydb`.`fotoprofessor` (
  `idfotoprofessor` INT NOT NULL AUTO_INCREMENT,
  `idprofessor` INT NOT NULL,
  `url` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idfotoprofessor`),
  INDEX `idprofessor_idx` (`idprofessor` ASC) VISIBLE,
  CONSTRAINT `idprofessor`
    FOREIGN KEY (`idprofessor`)
    REFERENCES `mydb`.`professor` (`idprofessor`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`avaliacaoprofessor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`avaliacaoprofessor` ;

CREATE TABLE IF NOT EXISTS `mydb`.`avaliacaoprofessor` (
  `idavaliacaoprofessor` INT NOT NULL AUTO_INCREMENT,
  `idusuario` INT NOT NULL,
  `idprofessor` INT NOT NULL,
  `avaliacao` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`idavaliacaoprofessor`),
  INDEX `idprofessor_idx` (`idprofessor` ASC) VISIBLE,
  CONSTRAINT `idusuario`
    FOREIGN KEY ()
    REFERENCES `mydb`.`usuario` ()
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idprofessor`
    FOREIGN KEY (`idprofessor`)
    REFERENCES `mydb`.`professor` (`idprofessor`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`mensagem`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`mensagem` ;

CREATE TABLE IF NOT EXISTS `mydb`.`mensagem` (
  `idmensagem` INT NOT NULL AUTO_INCREMENT,
  `iddestinatario` INT NOT NULL,
  `idremetente` INT NOT NULL,
  `texto` VARCHAR(500) NOT NULL,
  `dataenvio` DATETIME NOT NULL,
  `dataleitura` DATETIME NOT NULL,
  PRIMARY KEY (`idmensagem`),
  INDEX `iddestinatario_idx` (`iddestinatario` ASC) VISIBLE,
  INDEX `idremetente_idx` (`idremetente` ASC) VISIBLE,
  CONSTRAINT `iddestinatario`
    FOREIGN KEY (`iddestinatario`)
    REFERENCES `mydb`.`usuario` (`idusuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idremetente`
    FOREIGN KEY (`idremetente`)
    REFERENCES `mydb`.`usuario` (`idusuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`amizade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`amizade` ;

CREATE TABLE IF NOT EXISTS `mydb`.`amizade` (
  `idamizade` INT NOT NULL AUTO_INCREMENT,
  `idsolicitante` INT NOT NULL,
  `iddestinatario` INT NOT NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`idamizade`),
  INDEX `idsolicitante_idx` (`idsolicitante` ASC) VISIBLE,
  INDEX `iddestinatario_idx` (`iddestinatario` ASC) VISIBLE,
  CONSTRAINT `idsolicitante`
    FOREIGN KEY (`idsolicitante`)
    REFERENCES `mydb`.`usuario` (`idusuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `iddestinatario`
    FOREIGN KEY (`iddestinatario`)
    REFERENCES `mydb`.`usuario` (`idusuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`jantar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`jantar` ;

CREATE TABLE IF NOT EXISTS `mydb`.`jantar` (
  `idjantar` INT NOT NULL,
  `datainicio` DATETIME NOT NULL,
  `datafim` DATETIME NOT NULL,
  `tema` VARCHAR(45) NOT NULL,
  `idcriador` INT NOT NULL,
  PRIMARY KEY (`idjantar`),
  INDEX `idcriador_idx` (`idcriador` ASC) VISIBLE,
  CONSTRAINT `idcriador`
    FOREIGN KEY (`idcriador`)
    REFERENCES `mydb`.`usuario` (`idusuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`prato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`prato` ;

CREATE TABLE IF NOT EXISTS `mydb`.`prato` (
  `idprato` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `idjantar` INT NOT NULL,
  `` VARCHAR(45) NULL,
  PRIMARY KEY (`idprato`),
  INDEX `idjantar_idx` (`idjantar` ASC) VISIBLE,
  CONSTRAINT `idjantar`
    FOREIGN KEY (`idjantar`)
    REFERENCES `mydb`.`jantar` (`idjantar`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`atracao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`atracao` ;

CREATE TABLE IF NOT EXISTS `mydb`.`atracao` (
  `idatracao` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cache` FLOAT NOT NULL,
  `data` DATETIME NOT NULL,
  `idjantar` INT NULL,
  PRIMARY KEY (`idatracao`),
  UNIQUE INDEX `idjantar_UNIQUE` (`idjantar` ASC) VISIBLE,
  CONSTRAINT `idjantar`
    FOREIGN KEY (`idjantar`)
    REFERENCES `mydb`.`jantar` (`idjantar`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ingredientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ingredientes` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ingredientes` (
  `idingredientes` INT NOT NULL AUTO_INCREMENT,
  `produtos` VARCHAR(500) NOT NULL,
  `idjantar` INT NOT NULL,
  PRIMARY KEY (`idingredientes`),
  INDEX `idjantar_idx` (`idjantar` ASC) VISIBLE,
  CONSTRAINT `idjantar`
    FOREIGN KEY (`idjantar`)
    REFERENCES `mydb`.`jantar` (`idjantar`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`convite`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`convite` ;

CREATE TABLE IF NOT EXISTS `mydb`.`convite` (
  `idconvite` INT NOT NULL AUTO_INCREMENT,
  `idusuario` INT NOT NULL,
  `idjantar` INT NOT NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`idconvite`),
  INDEX `idjantar_idx` (`idjantar` ASC) VISIBLE,
  INDEX `idusuario_idx` (`idusuario` ASC) VISIBLE,
  CONSTRAINT `idjantar`
    FOREIGN KEY (`idjantar`)
    REFERENCES `mydb`.`jantar` (`idjantar`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idusuario`
    FOREIGN KEY (`idusuario`)
    REFERENCES `mydb`.`usuario` (`idusuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`conviteprofessor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`conviteprofessor` ;

CREATE TABLE IF NOT EXISTS `mydb`.`conviteprofessor` (
  `idconviteprofessor` INT NOT NULL AUTO_INCREMENT,
  `idjantar` INT NOT NULL,
  `idprofessor` INT NOT NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`idconviteprofessor`),
  INDEX `idjantar_idx` (`idjantar` ASC) VISIBLE,
  INDEX `idprofessor_idx` (`idprofessor` ASC) VISIBLE,
  CONSTRAINT `idjantar`
    FOREIGN KEY (`idjantar`)
    REFERENCES `mydb`.`jantar` (`idjantar`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idprofessor`
    FOREIGN KEY (`idprofessor`)
    REFERENCES `mydb`.`professor` (`idprofessor`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`comentario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`comentario` ;

CREATE TABLE IF NOT EXISTS `mydb`.`comentario` (
  `idcomentario` INT NOT NULL AUTO_INCREMENT,
  `idjantar` INT NOT NULL,
  `idusuario` INT NOT NULL,
  `texto` VARCHAR(500) NOT NULL,
  `data` DATETIME NOT NULL,
  PRIMARY KEY (`idcomentario`),
  INDEX `idjantar_idx` (`idjantar` ASC) VISIBLE,
  INDEX `idusuario_idx` (`idusuario` ASC) VISIBLE,
  CONSTRAINT `idjantar`
    FOREIGN KEY (`idjantar`)
    REFERENCES `mydb`.`jantar` (`idjantar`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idusuario`
    FOREIGN KEY (`idusuario`)
    REFERENCES `mydb`.`usuario` (`idusuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`imagemcomentario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`imagemcomentario` ;

CREATE TABLE IF NOT EXISTS `mydb`.`imagemcomentario` (
  `idimagemcomentario` INT NOT NULL AUTO_INCREMENT,
  `idcomentario` INT NOT NULL,
  `url` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idimagemcomentario`),
  INDEX `idcomentario_idx` (`idcomentario` ASC) VISIBLE,
  CONSTRAINT `idcomentario`
    FOREIGN KEY (`idcomentario`)
    REFERENCES `mydb`.`comentario` (`idcomentario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
