CREATE TABLE IF NOT EXISTS `springEx1`.`authorities`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL ,
    `authority` VARCHAR(45) NOT NULL ,
    PRIMARY KEY (`id`)
);

INSERT IGNORE INTO `springEx1`.`authorities` VALUES (NULL, 'john', 'write');
