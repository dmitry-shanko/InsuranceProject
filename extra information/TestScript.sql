SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`table4`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`table4` (
  `ID` INT NOT NULL ,
  `value4` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`table3`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`table3` (
  `ID` INT NOT NULL ,
  `value3` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) ,
  CONSTRAINT `fk_table3_table41`
    FOREIGN KEY (`ID` )
    REFERENCES `mydb`.`table4` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`table2`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`table2` (
  `ID` INT NOT NULL ,
  `value2` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) ,
  CONSTRAINT `fk_table2_table41`
    FOREIGN KEY (`ID` )
    REFERENCES `mydb`.`table4` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table2_table31`
    FOREIGN KEY (`ID` )
    REFERENCES `mydb`.`table3` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`table1`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`table1` (
  `ID` INT NOT NULL ,
  `value1` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) ,
  CONSTRAINT `fk_table1_table2`
    FOREIGN KEY (`ID` )
    REFERENCES `mydb`.`table2` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_table31`
    FOREIGN KEY (`ID` )
    REFERENCES `mydb`.`table3` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_table41`
    FOREIGN KEY (`ID` )
    REFERENCES `mydb`.`table4` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `mydb` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
