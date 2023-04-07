-- liquibase formatted sql
-- changeset j2eedemo_user:1
-- comment default character encoding
ALTER SCHEMA `j2eedemo` DEFAULT CHARACTER SET utf8  DEFAULT COLLATE utf8_general_ci ;

-- changeset j2eedemo_user:2
-- comment department table
CREATE TABLE IF NOT EXISTS `j2eedemo`.`department` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC),
    UNIQUE INDEX `name_UNIQUE` (`name` ASC))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

-- changeset j2eedemo_user:3
-- comment employee table
CREATE TABLE IF NOT EXISTS `j2eedemo`.`employee` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `active` TINYINT(1) NOT NULL,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `birth_date` DATE NULL DEFAULT NULL,
    `salary` DECIMAL(10,2) NULL DEFAULT NULL,
    `department_id` INT(11) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC),
    INDEX `fk_employee_department_idx` (`department_id` ASC),
    CONSTRAINT `fk_employee_department`
    FOREIGN KEY (`department_id`)
    REFERENCES `j2eedemo`.`department` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

-- changeset j2eedemo_user:4
-- comment manager table
CREATE TABLE IF NOT EXISTS `j2eedemo`.`manager` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `department_id` INT(11) NOT NULL,
    `employee_id` INT(11) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    INDEX `fk_manager_department_idx` (`department_id` ASC),
    INDEX `fk_manager_employee_idx` (`employee_id` ASC),
    INDEX `uq_department_employee` (`department_id` ASC, `employee_id` ASC),
    CONSTRAINT `fk_manager_department`
    FOREIGN KEY (`department_id`)
    REFERENCES `j2eedemo`.`department` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_manager_employee`
    FOREIGN KEY (`employee_id`)
    REFERENCES `j2eedemo`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;