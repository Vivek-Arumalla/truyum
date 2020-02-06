create database truyum;
use truyum;

create table user(
us_id int NOT NULL auto_increment,
us_username varchar(45) NOT NULL,
us_password varchar(200) NOT NULL,
PRIMARY KEY (`us_id`)
);
create table role(
ro_id int NOT NULL auto_increment,
ro_name varchar(45) NOT NULL,

PRIMARY KEY (`ro_id`)
);

CREATE TABLE IF NOT EXISTS user_role(
  `ur_id` INT NOT NULL AUTO_INCREMENT,
  `ur_us_id` INT NULL,
  `ur_ro_id` INT NULL,
  PRIMARY KEY (`ur_id`),
  INDEX `ur_us_fk_idx` (`ur_us_id` ASC),
  INDEX `ur_ro_fk_idx` (`ur_ro_id` ASC),
  CONSTRAINT `ur_us_fk`
    FOREIGN KEY (`ur_us_id`)
    REFERENCES user (`us_id`)
   ,
  CONSTRAINT `ur_ro_fk`
    FOREIGN KEY (`ur_ro_id`)
    REFERENCES role(`ro_id`)
    )
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `truyum`.`menu_item` (
  `me_id` INT NOT NULL AUTO_INCREMENT,
  `me_name` VARCHAR(100) NULL,
  `me_price` DOUBLE NULL,
  `me_active` BOOLEAN NULL,
  `me_date_of_launch` DATE NULL,
  `me_category` VARCHAR(45) NULL,
  `me_free_delivery` BOOLEAN NULL,
  `me_image_url` VARCHAR(200) NULL,
  PRIMARY KEY (`me_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `truyum`.`cart` (
  `ct_id` INT NOT NULL AUTO_INCREMENT,
  `ct_us_id` INT NULL,
  `ct_me_id` INT NULL,
  `ct_count` INT NULL,
  PRIMARY KEY (`ct_id`),
  INDEX `ct_us_fk_idx` (`ct_us_id` ASC),
  INDEX `ct_me_fk_idx` (`ct_me_id` ASC),
  CONSTRAINT `ct_us_fk`
    FOREIGN KEY (`ct_us_id`)
    REFERENCES `truyum`.`user` (`us_id`),
  CONSTRAINT `ct_me_fk`
    FOREIGN KEY (`ct_me_id`)
    REFERENCES `truyum`.`menu_item` (`me_id`)
   )
ENGINE = InnoDB;


