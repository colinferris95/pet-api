CREATE TABLE `master`.`pets` (
 `id` INT(11) NOT NULL AUTO_INCREMENT,
 PRIMARY KEY (`id`));

ALTER TABLE `master`.`pets`
    ADD COLUMN `name` MEDIUMTEXT NULL AFTER `id`,
ADD COLUMN `description` MEDIUMTEXT NULL AFTER `name`;

CREATE TABLE `master`.`owners` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
PRIMARY KEY (`id`));
