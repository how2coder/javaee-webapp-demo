-- liquibase formatted sql
-- changeset j2eedemo:1
-- comment default character encoding
ALTER SCHEMA `j2eedemo` DEFAULT CHARACTER SET utf8  DEFAULT COLLATE utf8_general_ci ;

-- changeset j2eedemo:2
-- comment department table
CREATE TABLE IF NOT EXISTS `j2eedemo`.`department` (
    `id` INT(11) NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `name_uq` (`name` ASC)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;