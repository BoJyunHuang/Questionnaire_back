CREATE TABLE IF NOT EXISTS `questionnaire_back`.`questionnaire` (
  `serial_number` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(150) NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  PRIMARY KEY (`serial_number`));

CREATE TABLE IF NOT EXISTS `questionnaire_back`.`questions` (
  `serial_number` INT NOT NULL AUTO_INCREMENT,
  `qn_number` INT NOT NULL,
  `question` VARCHAR(90) NOT NULL,
  `kind` VARCHAR(20) NOT NULL,
  `is_required` TINYINT NOT NULL,
  `selections` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`serial_number`));

CREATE TABLE IF NOT EXISTS `questionnaire_back`.`records` (
  `serial_number` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `phone_number` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `qn_number` INT NOT NULL,
  `finish_time` DATETIME NOT NULL,
  `answers` VARCHAR(90) NOT NULL,
  PRIMARY KEY (`serial_number`));
