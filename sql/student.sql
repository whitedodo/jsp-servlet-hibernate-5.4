CREATE TABLE `student` (
  `studentno` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(100) NULL,
  `createdate` DATE NULL,
  PRIMARY KEY (`studentno`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

INSERT INTO `student` (`name`, `address`, `createdate`) VALUES ('홍길동', '연습', '21-3-4');
