-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema flighttrackerdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `flighttrackerdb` ;

-- -----------------------------------------------------
-- Schema flighttrackerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `flighttrackerdb` DEFAULT CHARACTER SET utf8 ;
USE `flighttrackerdb` ;

-- -----------------------------------------------------
-- Table `flight_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `flight_details` ;

CREATE TABLE IF NOT EXISTS `flight_details` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `airline` VARCHAR(45) NOT NULL,
  `airplane_capacity` INT(11) NOT NULL,
  `seats_occupied` INT(11) NULL DEFAULT NULL,
  `scheduled_departure` DATETIME NOT NULL,
  `actual_departure` DATETIME NULL DEFAULT NULL,
  `scheduled_arrival` DATETIME NOT NULL,
  `actual_arrival` DATETIME NULL DEFAULT NULL,
  `departure_airport` VARCHAR(3) NOT NULL,
  `arrival_airport` VARCHAR(3) NOT NULL,
  `airplane` VARCHAR(45) NULL DEFAULT NULL,
  `flight_number` VARCHAR(45) NULL DEFAULT NULL,
  `number_of_stops` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

SET SQL_MODE = '';
DROP USER IF EXISTS user@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'user'@'localhost' IDENTIFIED BY 'user';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'user'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `flight_details`
-- -----------------------------------------------------
START TRANSACTION;
USE `flighttrackerdb`;
INSERT INTO `flight_details` (`id`, `airline`, `airplane_capacity`, `seats_occupied`, `scheduled_departure`, `actual_departure`, `scheduled_arrival`, `actual_arrival`, `departure_airport`, `arrival_airport`, `airplane`, `flight_number`, `number_of_stops`) VALUES (1, 'Southwest', 175, 170, '2018-11-12 06:00:00', NULL, '2018-11-12 10:00:00', NULL, 'DEN', 'MDW', 'Boeing 737-MAX', NULL, 0);

COMMIT;

