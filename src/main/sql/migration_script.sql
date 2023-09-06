-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: gopikannan_saravanan_corejava_project
-- Source Schemata: gopikannan_saravanan_corejava_project
-- Created: Tue Sep  5 08:24:59 2023
-- Workbench Version: 8.0.32
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema gopikannan_saravanan_corejava_project
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `gopikannan_saravanan_corejava_project` ;
CREATE SCHEMA IF NOT EXISTS `gopikannan_saravanan_corejava_project` ;

-- ----------------------------------------------------------------------------
-- Table gopikannan_saravanan_corejava_project.donations
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `gopikannan_saravanan_corejava_project`.`donations` (
  `donationId` INT NOT NULL AUTO_INCREMENT,
  `contribution` DECIMAL(10,2) NOT NULL,
  `userid` INT NOT NULL,
  `fundraise_id` INT NOT NULL,
  PRIMARY KEY (`donationId`),
  INDEX `fk_donations_userdata_userid` (`userid` ASC) VISIBLE,
  INDEX `fk_fundraisedetails_fundraiseid` (`fundraise_id` ASC) VISIBLE,
  CONSTRAINT `fk_donations_userdata_userid`
    FOREIGN KEY (`userid`)
    REFERENCES `gopikannan_saravanan_corejava_project`.`userdata` (`userid`),
  CONSTRAINT `fk_fundraisedetails_fundraiseid`
    FOREIGN KEY (`fundraise_id`)
    REFERENCES `gopikannan_saravanan_corejava_project`.`fundraisedetails` (`fundraise_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table gopikannan_saravanan_corejava_project.fundraisedetails
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `gopikannan_saravanan_corejava_project`.`fundraisedetails` (
  `fundraise_id` INT NOT NULL AUTO_INCREMENT,
  `cause` VARCHAR(50) NOT NULL,
  `image_url` VARCHAR(500) NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `story` TEXT NOT NULL,
  `amount_expected` DECIMAL(10,2) NOT NULL,
  `userid` INT NOT NULL,
  PRIMARY KEY (`fundraise_id`),
  INDEX `fk_userdata_userid` (`userid` ASC) VISIBLE,
  CONSTRAINT `fk_userdata_userid`
    FOREIGN KEY (`userid`)
    REFERENCES `gopikannan_saravanan_corejava_project`.`userdata` (`userid`))
ENGINE = InnoDB
AUTO_INCREMENT = 551
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table gopikannan_saravanan_corejava_project.userdata
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `gopikannan_saravanan_corejava_project`.`userdata` (
  `userid` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(100) NULL DEFAULT NULL,
  `user_mail` VARCHAR(255) NULL DEFAULT NULL,
  `user_pwd` VARCHAR(50) NULL DEFAULT NULL,
  `mobileno` VARCHAR(10) NULL DEFAULT NULL,
  `user_account_no` VARCHAR(50) NULL DEFAULT NULL,
  `user_ifsc` VARCHAR(20) NULL DEFAULT NULL,
  `user_account_holder` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
SET FOREIGN_KEY_CHECKS = 1;
