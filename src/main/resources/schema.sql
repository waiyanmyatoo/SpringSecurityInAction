CREATE TABLE IF NOT EXISTS `spring`.`users`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    `enabled` INT NOT NULL,
    PRIMARY KEY (`id`)
);

INSERT IGNORE INTO `spring`.`users` VALUES (NULL, 'john', '12345', '1');