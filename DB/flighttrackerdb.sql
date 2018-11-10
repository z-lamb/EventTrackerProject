-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema flightTrackerdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `flightTrackerdb` ;

-- -----------------------------------------------------
-- Schema flightTrackerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `flightTrackerdb` DEFAULT CHARACTER SET utf8 ;
USE `flightTrackerdb` ;

-- -----------------------------------------------------
-- Table `flight_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `flight_details` ;

CREATE TABLE IF NOT EXISTS `flight_details` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `airline` VARCHAR(45) NOT NULL,
  `airplane_capacity` INT NOT NULL,
  `seats_occupied` INT NULL,
  `scheduled_departure` DATETIME NOT NULL,
  `actual_departure` DATETIME NULL,
  `scheduled_arrival` DATETIME NOT NULL,
  `actual_arrival` DATETIME NULL,
  `departure_airport` VARCHAR(3) NOT NULL,
  `arrival_airport` VARCHAR(3) NOT NULL,
  `airplane` VARCHAR(200) NOT NULL,
  `flight_number` VARCHAR(45) NOT NULL,
  `number_of_stops` INT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS user@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'user'@'localhost' IDENTIFIED BY 'user';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'user'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
