CREATE TABLE IF NOT EXISTS `inventario`.`productos` (
  `id_producto` BIGINT NOT NULL AUTO_INCREMENT,
  `cantidad` VARBINARY(255) NULL DEFAULT NULL,
  `estado` BIT(1) NULL DEFAULT NULL,
  `nombre_producto` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_producto`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci