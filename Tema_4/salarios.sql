SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema reporte
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema reporte
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `reporte` DEFAULT CHARACTER SET utf8 ;
USE `reporte` ;

-- -----------------------------------------------------
-- Table `reporte`.`salario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reporte`.`salario` (
  `id` INT NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  `salario` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


