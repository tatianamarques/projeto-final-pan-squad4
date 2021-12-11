-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bluebank
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bluebank
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bluebank` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `bluebank` ;

-- -----------------------------------------------------
-- Table `bluebank`.`agencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bluebank`.`agencia` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `bairro` VARCHAR(255) NULL DEFAULT NULL,
  `cep` VARCHAR(255) NULL DEFAULT NULL,
  `cidade` VARCHAR(255) NULL DEFAULT NULL,
  `complemento` VARCHAR(255) NULL DEFAULT NULL,
  `logradouro` VARCHAR(255) NULL DEFAULT NULL,
  `numero_endereco` VARCHAR(255) NULL DEFAULT NULL,
  `uf` VARCHAR(255) NULL DEFAULT NULL,
  `numero_agencia` VARCHAR(255) NOT NULL,
  `ddd` VARCHAR(255) NULL DEFAULT NULL,
  `numero_telefone` VARCHAR(255) NULL DEFAULT NULL,
  `tipo_telefone` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_jhpw8jq3y3pslmkoihl9nypvp` (`numero_agencia` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bluebank`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bluebank`.`cliente` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `ativo` BIT(1) NOT NULL,
  `cpf` VARCHAR(255) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_r1u8010d60num5vc8fp0q1j2a` (`cpf` ASC) VISIBLE,
  UNIQUE INDEX `UK_cmxo70m08n43599l3h0h07cc6` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bluebank`.`conta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bluebank`.`conta` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `data_abertura` DATE NOT NULL,
  `esta_bloqueada` BIT(1) NOT NULL,
  `numero` VARCHAR(255) NOT NULL,
  `saldo` DECIMAL(19,2) NOT NULL,
  `saldo_especial` DECIMAL(19,2) NULL DEFAULT NULL,
  `senha` VARCHAR(255) NOT NULL,
  `tipo_conta` VARCHAR(255) NOT NULL,
  `agencia_id` BIGINT NULL DEFAULT NULL,
  `cliente_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_i0yefx3uy4mtik3ldcc9cu0a9` (`numero` ASC) VISIBLE,
  INDEX `FKtlb2q7ipxepjj5uq0aj6lxfgs` (`agencia_id` ASC) VISIBLE,
  INDEX `FKfksaesgpmec0cph81iq5or1wn` (`cliente_id` ASC) VISIBLE,
  CONSTRAINT `FKfksaesgpmec0cph81iq5or1wn`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `bluebank`.`cliente` (`id`),
  CONSTRAINT `FKtlb2q7ipxepjj5uq0aj6lxfgs`
    FOREIGN KEY (`agencia_id`)
    REFERENCES `bluebank`.`agencia` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bluebank`.`transacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bluebank`.`transacao` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `tipo_transacao` VARCHAR(255) NOT NULL,
  `valor` DECIMAL(19,2) NOT NULL,
  `conta_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK6968iodq71yxdsg3ctxmnffv1` (`conta_id` ASC) VISIBLE,
  CONSTRAINT `FK6968iodq71yxdsg3ctxmnffv1`
    FOREIGN KEY (`conta_id`)
    REFERENCES `bluebank`.`conta` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bluebank`.`conta_transacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bluebank`.`conta_transacao` (
  `conta_id` BIGINT NOT NULL,
  `transacao_id` BIGINT NOT NULL,
  UNIQUE INDEX `UK_h6epb8ajkdtg6b2d5o0c0pl42` (`transacao_id` ASC) VISIBLE,
  INDEX `FKta46eem7sxbnc4a4210bbmbj7` (`conta_id` ASC) VISIBLE,
  CONSTRAINT `FKes2uioc9qhosmduah4hquh3gw`
    FOREIGN KEY (`transacao_id`)
    REFERENCES `bluebank`.`transacao` (`id`),
  CONSTRAINT `FKta46eem7sxbnc4a4210bbmbj7`
    FOREIGN KEY (`conta_id`)
    REFERENCES `bluebank`.`conta` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bluebank`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bluebank`.`endereco` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `bairro` VARCHAR(255) NOT NULL,
  `cep` VARCHAR(255) NOT NULL,
  `cidade` VARCHAR(255) NOT NULL,
  `complemento` VARCHAR(255) NULL DEFAULT NULL,
  `logradouro` VARCHAR(255) NOT NULL,
  `numero` VARCHAR(255) NOT NULL,
  `uf` VARCHAR(255) NULL DEFAULT NULL,
  `cliente_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK8s7ivtl4foyhrfam9xqom73n9` (`cliente_id` ASC) VISIBLE,
  CONSTRAINT `FK8s7ivtl4foyhrfam9xqom73n9`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `bluebank`.`cliente` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bluebank`.`perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bluebank`.`perfil` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome_role` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bluebank`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bluebank`.`usuario` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `ativo` BIT(1) NULL DEFAULT NULL,
  `login` VARCHAR(255) NULL DEFAULT NULL,
  `senha` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bluebank`.`perfil_usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bluebank`.`perfil_usuarios` (
  `perfil_id` BIGINT NOT NULL,
  `usuarios_id` BIGINT NOT NULL,
  INDEX `FKrp5ubbau2314wsv5ieh2hnxvj` (`usuarios_id` ASC) VISIBLE,
  INDEX `FKhxi02sqxq10qiaat76jrgagu9` (`perfil_id` ASC) VISIBLE,
  CONSTRAINT `FKhxi02sqxq10qiaat76jrgagu9`
    FOREIGN KEY (`perfil_id`)
    REFERENCES `bluebank`.`perfil` (`id`),
  CONSTRAINT `FKrp5ubbau2314wsv5ieh2hnxvj`
    FOREIGN KEY (`usuarios_id`)
    REFERENCES `bluebank`.`usuario` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bluebank`.`perfis_usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bluebank`.`perfis_usuarios` (
  `perfil_id` BIGINT NOT NULL,
  `usuario_id` BIGINT NOT NULL,
  INDEX `FKq32tc3w6mdb5qgid0gyass272` (`usuario_id` ASC) VISIBLE,
  INDEX `FKgxvnjpkuly6rht926bigk8o8t` (`perfil_id` ASC) VISIBLE,
  CONSTRAINT `FKgxvnjpkuly6rht926bigk8o8t`
    FOREIGN KEY (`perfil_id`)
    REFERENCES `bluebank`.`usuario` (`id`),
  CONSTRAINT `FKq32tc3w6mdb5qgid0gyass272`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `bluebank`.`perfil` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bluebank`.`telefone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bluebank`.`telefone` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `ddd` VARCHAR(255) NULL DEFAULT NULL,
  `numero` VARCHAR(255) NULL DEFAULT NULL,
  `tipo_telefone` VARCHAR(255) NULL DEFAULT NULL,
  `cliente_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK8aafha0njkoyoe3kvrwsy3g8u` (`cliente_id` ASC) VISIBLE,
  CONSTRAINT `FK8aafha0njkoyoe3kvrwsy3g8u`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `bluebank`.`cliente` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
