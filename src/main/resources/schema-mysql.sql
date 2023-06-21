CREATE TABLE IF NOT EXISTS `questionnaire`.`questionnaire` (
  `serial_number` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(150) NOT NULL,
  `status` VARCHAR(20) NOT NULL,
  `start_time` DATETIME NOT NULL,
  `end_time` DATETIME NOT NULL,
  `question_amount` INT NOT NULL,
  PRIMARY KEY (`serial_number`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `questionnaire`.`questions` (
  `serial_number` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `number` INT NOT NULL,
  `kind` VARCHAR(20) NOT NULL,
  `not_empty` TINYINT NOT NULL,
  `question` VARCHAR(90) NOT NULL,
  `selection` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`serial_number`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `questionnaire`.`records` (
  `serial_number` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `phone_number` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `finish_time` DATETIME NOT NULL,
  `answers` VARCHAR(90) NOT NULL,
  PRIMARY KEY (`serial_number`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;