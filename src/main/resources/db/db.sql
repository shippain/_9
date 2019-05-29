CREATE TABLE `sales`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);

CREATE TABLE `sales`.`order` (
                                 `id` INT NOT NULL AUTO_INCREMENT,
                                 `date` DATETIME NOT NULL,
                                 `phone` VARCHAR(20) NOT NULL,
                                 PRIMARY KEY (`id`));

CREATE TABLE `sales`.`order_products` (
                                          `order_id` INT NOT NULL,
                                          `product_id` INT NOT NULL);

ALTER TABLE `sales`.`order_products`
    ADD INDEX `opo_idx` (`order_id` ASC) VISIBLE,
    ADD INDEX `opp_idx` (`product_id` ASC) VISIBLE;
;
ALTER TABLE `sales`.`order_products`
    ADD CONSTRAINT `opo`
        FOREIGN KEY (`order_id`)
            REFERENCES `sales`.`order` (`id`)
            ON DELETE RESTRICT
            ON UPDATE RESTRICT,
    ADD CONSTRAINT `opp`
        FOREIGN KEY (`product_id`)
            REFERENCES `sales`.`product` (`id`)
            ON DELETE RESTRICT
            ON UPDATE RESTRICT;
