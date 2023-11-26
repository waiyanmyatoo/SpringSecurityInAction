CREATE TABLE IF NOT EXISTS `spring`.`authorities`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL ,
    `authority` VARCHAR(45) NOT NULL ,
    PRIMARY KEY (`id`)
);

INSERT IGNORE INTO `spring`.`authorities` VALUES (NULL, 'john', 'write');
