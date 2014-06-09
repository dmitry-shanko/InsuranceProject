SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `insurancedb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `insurancedb` ;

-- -----------------------------------------------------
-- Table `insurancedb`.`roles`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `insurancedb`.`roles` (
  `idroles` INT NOT NULL AUTO_INCREMENT ,
  `role` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idroles`) ,
  UNIQUE INDEX `idroles_UNIQUE` (`idroles` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `insurancedb`.`client`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `insurancedb`.`client` (
  `idusers` INT NOT NULL ,
  `experience` INT NOT NULL ,
  PRIMARY KEY (`idusers`) ,
  UNIQUE INDEX `idusers_UNIQUE` (`idusers` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `insurancedb`.`users`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `insurancedb`.`users` (
  `idusers` INT NOT NULL AUTO_INCREMENT ,
  `idroles` INT NOT NULL ,
  `email` CHAR(40) NOT NULL ,
  `password` CHAR(16) NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `surname` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idusers`) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) ,
  UNIQUE INDEX `idusers_UNIQUE` (`idusers` ASC) ,
  INDEX `fk_users_roles_idx` (`idroles` ASC) ,
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`idroles` )
    REFERENCES `insurancedb`.`roles` (`idroles` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_client1`
    FOREIGN KEY (`idusers` )
    REFERENCES `insurancedb`.`client` (`idusers` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `insurancedb`.`insurancetypes`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `insurancedb`.`insurancetypes` (
  `idtype` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idtype`) ,
  UNIQUE INDEX `idtype_UNIQUE` (`idtype` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `insurancedb`.`insurance`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `insurancedb`.`insurance` (
  `idinsurance` INT NOT NULL AUTO_INCREMENT ,
  `status` TINYINT(1) NOT NULL ,
  `price` INT NOT NULL ,
  `risksum` INT NOT NULL ,
  `idtype` INT NOT NULL ,
  `term` INT NOT NULL ,
  UNIQUE INDEX `idinsurance_UNIQUE` (`idinsurance` ASC) ,
  PRIMARY KEY (`idinsurance`) ,
  INDEX `fk_insurance_insurancetypes1_idx` (`idtype` ASC) ,
  CONSTRAINT `fk_insurance_insurancetypes1`
    FOREIGN KEY (`idtype` )
    REFERENCES `insurancedb`.`insurancetypes` (`idtype` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `insurancedb`.`carinsurances`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `insurancedb`.`carinsurances` (
  `idusers` INT NOT NULL ,
  `idinsurance` INT NOT NULL ,
  PRIMARY KEY (`idusers`, `idinsurance`) ,
  INDEX `fk_carinsurances_insurance1_idx` (`idinsurance` ASC) ,
  INDEX `fk_carinsurances_client1_idx` (`idusers` ASC) ,
  CONSTRAINT `fk_carinsurances_insurance1`
    FOREIGN KEY (`idinsurance` )
    REFERENCES `insurancedb`.`insurance` (`idinsurance` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_carinsurances_client1`
    FOREIGN KEY (`idusers` )
    REFERENCES `insurancedb`.`client` (`idusers` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `insurancedb` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
