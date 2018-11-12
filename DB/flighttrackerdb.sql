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
-- Table `airline`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `airline` ;

CREATE TABLE IF NOT EXISTS `airline` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airplane_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `airplane_type` ;

CREATE TABLE IF NOT EXISTS `airplane_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `maker` VARCHAR(45) NULL,
  `type` VARCHAR(45) NOT NULL,
  `capacity` INT NOT NULL,
  `wifi` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airplane`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `airplane` ;

CREATE TABLE IF NOT EXISTS `airplane` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `airline_id` INT NOT NULL,
  `airplane_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_airplane_airline1_idx` (`airline_id` ASC),
  INDEX `fk_airplane_airplane_type1_idx` (`airplane_type_id` ASC),
  CONSTRAINT `fk_airplane_airline1`
    FOREIGN KEY (`airline_id`)
    REFERENCES `airline` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_airplane_airplane_type1`
    FOREIGN KEY (`airplane_type_id`)
    REFERENCES `airplane_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `airport` ;

CREATE TABLE IF NOT EXISTS `airport` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `code` VARCHAR(3) NOT NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `flight`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `flight` ;

CREATE TABLE IF NOT EXISTS `flight` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `seats_occupied` INT(11) NULL DEFAULT NULL,
  `scheduled_departure` DATETIME NOT NULL,
  `actual_departure` DATETIME NULL DEFAULT NULL,
  `scheduled_arrival` DATETIME NOT NULL,
  `actual_arrival` DATETIME NULL DEFAULT NULL,
  `flight_number` VARCHAR(45) NULL DEFAULT NULL,
  `number_of_stops` INT(2) NULL DEFAULT NULL,
  `available` TINYINT(1) NOT NULL,
  `airplane_id` INT NOT NULL,
  `departure_airport` INT NOT NULL,
  `arrival_airport` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_flight_details_airplane_idx` (`airplane_id` ASC),
  INDEX `fk_flight_details_airport1_idx` (`departure_airport` ASC),
  INDEX `fk_flight_details_airport2_idx` (`arrival_airport` ASC),
  CONSTRAINT `fk_flight_details_airplane`
    FOREIGN KEY (`airplane_id`)
    REFERENCES `airplane` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_flight_details_airport1`
    FOREIGN KEY (`departure_airport`)
    REFERENCES `airport` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_flight_details_airport2`
    FOREIGN KEY (`arrival_airport`)
    REFERENCES `airport` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
-- Data for table `airline`
-- -----------------------------------------------------
START TRANSACTION;
USE `flighttrackerdb`;
INSERT INTO `airline` (`id`, `name`) VALUES (1, 'Alaska Airlines');
INSERT INTO `airline` (`id`, `name`) VALUES (2, 'American Airlines');
INSERT INTO `airline` (`id`, `name`) VALUES (3, 'British Airways');
INSERT INTO `airline` (`id`, `name`) VALUES (4, 'Delta Air Lines');
INSERT INTO `airline` (`id`, `name`) VALUES (5, 'Frontier Airlines');
INSERT INTO `airline` (`id`, `name`) VALUES (6, 'Lufthansa');
INSERT INTO `airline` (`id`, `name`) VALUES (7, 'Southwest Airlines');
INSERT INTO `airline` (`id`, `name`) VALUES (8, 'Spirit Airlines');
INSERT INTO `airline` (`id`, `name`) VALUES (9, 'United Airlines');
INSERT INTO `airline` (`id`, `name`) VALUES (10, 'Private');

COMMIT;


-- -----------------------------------------------------
-- Data for table `airplane_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `flighttrackerdb`;
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (1, 'Airbus', 'A320-214', 149, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (2, 'Boeing', '737-900ER', 178, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (3, 'Boeing', '737-800', 160, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (4, 'Boeing', '737-700', 124, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (5, 'Bombardier', 'Q400', 76, 0);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (6, 'Embraer', '175', 76, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (7, 'Airbus', 'A319', 128, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (8, 'Airbus', 'A320', 150, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (9, 'Airbus', 'A321', 181, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (10, 'Airbus', 'A321 Transcon', 102, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (11, 'Airbus', 'A330-200', 247, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (12, 'Airbus', 'A330-300', 291, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (13, 'Boeing', '737-MAX', 172, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (14, 'Boeing', '757-200', 176, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (15, 'Boeing', '767-300', 209, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (16, 'Boeing', '777-200ER', 200, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (17, 'Boeing', '777-300ER', 304, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (18, 'Boeing', '787-8', 226, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (19, 'Boeing', '787-9', 285, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (20, 'CRJ', '700', 63, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (21, 'CRJ', '900', 76, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (22, 'CRJ', '200', 50, 0);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (23, 'ERJ', '140', 44, 0);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (24, 'ERJ', '145', 50, 0);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (25, 'ERJ', '175', 76, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (26, NULL, 'E190', 99, 1);
INSERT INTO `airplane_type` (`id`, `maker`, `type`, `capacity`, `wifi`) VALUES (27, NULL, 'MD80', 140, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `airplane`
-- -----------------------------------------------------
START TRANSACTION;
USE `flighttrackerdb`;
INSERT INTO `airplane` (`id`, `airline_id`, `airplane_type_id`) VALUES (1, 1, 1);
INSERT INTO `airplane` (`id`, `airline_id`, `airplane_type_id`) VALUES (2, 1, 2);
INSERT INTO `airplane` (`id`, `airline_id`, `airplane_type_id`) VALUES (3, 1, 3);
INSERT INTO `airplane` (`id`, `airline_id`, `airplane_type_id`) VALUES (4, 1, 4);
INSERT INTO `airplane` (`id`, `airline_id`, `airplane_type_id`) VALUES (5, 1, 5);
INSERT INTO `airplane` (`id`, `airline_id`, `airplane_type_id`) VALUES (6, 1, 6);
INSERT INTO `airplane` (`id`, `airline_id`, `airplane_type_id`) VALUES (7, 2, 7);
INSERT INTO `airplane` (`id`, `airline_id`, `airplane_type_id`) VALUES (8, 2, 8);
INSERT INTO `airplane` (`id`, `airline_id`, `airplane_type_id`) VALUES (9, 2, 9);
INSERT INTO `airplane` (`id`, `airline_id`, `airplane_type_id`) VALUES (10, 2, 10);
INSERT INTO `airplane` (`id`, `airline_id`, `airplane_type_id`) VALUES (11, 2, 11);
INSERT INTO `airplane` (`id`, `airline_id`, `airplane_type_id`) VALUES (12, 2, 12);
INSERT INTO `airplane` (`id`, `airline_id`, `airplane_type_id`) VALUES (13, 2, 13);
INSERT INTO `airplane` (`id`, `airline_id`, `airplane_type_id`) VALUES (14, 7, 13);
INSERT INTO `airplane` (`id`, `airline_id`, `airplane_type_id`) VALUES (15, 7, 13);
INSERT INTO `airplane` (`id`, `airline_id`, `airplane_type_id`) VALUES (16, 7, 3);
INSERT INTO `airplane` (`id`, `airline_id`, `airplane_type_id`) VALUES (17, 7, 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `airport`
-- -----------------------------------------------------
START TRANSACTION;
USE `flighttrackerdb`;
INSERT INTO `airport` (`id`, `name`, `code`, `city`, `state`, `country`) VALUES (1, 'Denver International Airport', 'DEN', 'Denver', 'CO', 'US');
INSERT INTO `airport` (`id`, `name`, `code`, `city`, `state`, `country`) VALUES (2, 'Chicago Midway Airport', 'MDW', 'Chicago', 'IL', 'US');
INSERT INTO `airport` (`id`, `name`, `code`, `city`, `state`, `country`) VALUES (3, 'Chicago Ohare Airport', 'ORD', 'Chicago', 'IL', 'US');
INSERT INTO `airport` (`id`, `name`, `code`, `city`, `state`, `country`) VALUES (4, 'Seattle-Tacoma Airport', 'SEA', 'Seattle', 'WA', 'US');

COMMIT;


-- -----------------------------------------------------
-- Data for table `flight`
-- -----------------------------------------------------
START TRANSACTION;
USE `flighttrackerdb`;
INSERT INTO `flight` (`id`, `seats_occupied`, `scheduled_departure`, `actual_departure`, `scheduled_arrival`, `actual_arrival`, `flight_number`, `number_of_stops`, `available`, `airplane_id`, `departure_airport`, `arrival_airport`) VALUES (1, 170, '2018-11-12 06:00:00', NULL, '2018-11-12 10:00:00', NULL, '1235', 0, 1, 15, 1, 2);
INSERT INTO `flight` (`id`, `seats_occupied`, `scheduled_departure`, `actual_departure`, `scheduled_arrival`, `actual_arrival`, `flight_number`, `number_of_stops`, `available`, `airplane_id`, `departure_airport`, `arrival_airport`) VALUES (2, 165, '2018-11-12 10:00:00', NULL, '2018-11-12 13:00:00', NULL, '1234', 0, 1, 15, 1, 2);

COMMIT;

