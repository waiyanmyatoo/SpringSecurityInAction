CREATE TABLE IF NOT EXISTS `springEx1`.`users`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NOT NULL UNIQUE,
    `enabled` INT NOT NULL,
    PRIMARY KEY (`id`)
);

INSERT IGNORE INTO `springEx1`.`users` VALUES (NULL, 'john', '12345',  'exercise1@email.com', '1');