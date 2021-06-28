-- MySQL Script generated by MySQL Workbench
-- Fri May 14 19:15:08 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema enade
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema enade
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `enade` DEFAULT CHARACTER SET utf8 ;
USE `enade` ;

-- -----------------------------------------------------
-- Table `enade`.`TipoUsuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enade`.`TipoUsuario` (
  `idTipoUsuario` INT NOT NULL AUTO_INCREMENT,
  `nomeTipoUsuario` VARCHAR(9) NOT NULL,
  PRIMARY KEY (`idTipoUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `enade`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enade`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `senha` VARCHAR(255) NULL,
  `TipoUsuario_idTipoUsuario` INT NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `senha_UNIQUE` (`senha` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) VISIBLE,
  INDEX `fk_Usuario_TipoUsuario_idx` (`TipoUsuario_idTipoUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_TipoUsuario`
    FOREIGN KEY (`TipoUsuario_idTipoUsuario`)
    REFERENCES `enade`.`TipoUsuario` (`idTipoUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `enade`.`TipoQuestao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enade`.`TipoQuestao` (
  `idTipoQuestao` INT NOT NULL AUTO_INCREMENT,
  `nomeTipoQuestao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoQuestao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `enade`.`Questao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enade`.`Questao` (
  `idQuestao` INT NOT NULL AUTO_INCREMENT,
  `descricaoQuestao` VARCHAR(45) NOT NULL,
  `alternativaA` VARCHAR(45) NULL,
  `alternativaB` VARCHAR(45) NULL,
  `alternativaC` VARCHAR(45) NULL,
  `alternativaD` VARCHAR(45) NULL,
  `alternativaE` VARCHAR(45) NULL,
  `questaoCorreta` CHAR(1) NULL,
  `estadoQuestao` TINYINT NULL,
  `TipoQuestao_idTipoQuestao` INT NOT NULL,
  PRIMARY KEY (`idQuestao`),
  INDEX `fk_Questao_TipoQuestao1_idx` (`TipoQuestao_idTipoQuestao` ASC) VISIBLE,
  CONSTRAINT `fk_Questao_TipoQuestao1`
    FOREIGN KEY (`TipoQuestao_idTipoQuestao`)
    REFERENCES `enade`.`TipoQuestao` (`idTipoQuestao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `enade`.`Prova`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enade`.`Prova` (
  `idProva` INT NOT NULL AUTO_INCREMENT,
  `dataProva` DATE NOT NULL,
  PRIMARY KEY (`idProva`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `enade`.`Prova_has_Questao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enade`.`Prova_has_Questao` (
  `Prova_idProva` INT NOT NULL,
  `Questao_idQuestao` INT NOT NULL,
  PRIMARY KEY (`Prova_idProva`, `Questao_idQuestao`),
  INDEX `fk_Prova_has_Questao_Questao1_idx` (`Questao_idQuestao` ASC) VISIBLE,
  INDEX `fk_Prova_has_Questao_Prova1_idx` (`Prova_idProva` ASC) VISIBLE,
  CONSTRAINT `fk_Prova_has_Questao_Prova1`
    FOREIGN KEY (`Prova_idProva`)
    REFERENCES `enade`.`Prova` (`idProva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Prova_has_Questao_Questao1`
    FOREIGN KEY (`Questao_idQuestao`)
    REFERENCES `enade`.`Questao` (`idQuestao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `enade`.`Resultado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enade`.`Resultado` (
  `idResultado` INT NOT NULL AUTO_INCREMENT,
  `valorObtido` DOUBLE NOT NULL,
  `Usuario_idUsuario` INT NOT NULL,
  `Prova_idProva` INT NOT NULL,
  PRIMARY KEY (`idResultado`),
  INDEX `fk_Resultado_Usuario1_idx` (`Usuario_idUsuario` ASC) VISIBLE,
  INDEX `fk_Resultado_Prova1_idx` (`Prova_idProva` ASC) VISIBLE,
  CONSTRAINT `fk_Resultado_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `enade`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Resultado_Prova1`
    FOREIGN KEY (`Prova_idProva`)
    REFERENCES `enade`.`Prova` (`idProva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;