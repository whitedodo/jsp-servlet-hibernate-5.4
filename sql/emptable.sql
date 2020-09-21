CREATE TABLE `emptable` (
  `empno` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NULL,
  `address` VARCHAR(100) NULL,
  `createdate` DATE NULL,
  PRIMARY KEY (`empno`));

INSERT INTO `emptable` (`name`, `address`, `createdate`) VALUES ('하하', '안녕', '20-09-1');