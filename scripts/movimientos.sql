CREATE TABLE IF NOT EXISTS `inventario`.`movimientos` (
  `id_movimiento` BIGINT NOT NULL AUTO_INCREMENT,
  `cantidad` VARBINARY(255) NULL DEFAULT NULL,
  `fecha_hora` DATETIME(6) NULL DEFAULT NULL,
  `tipo` BIT(1) NULL DEFAULT NULL,
  `id_producto` BIGINT NULL DEFAULT NULL,
  `id_usuario` BIGINT NOT NULL,
  PRIMARY KEY (`id_movimiento`),
  INDEX `FKq7gb4wrm2hx3qiwh2q9vll7l2` (`id_producto` ASC) VISIBLE,
  INDEX `FK2vy4x99hlkxynsue71d15e4ji` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `FK2vy4x99hlkxynsue71d15e4ji`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `inventario`.`usuarios` (`id_usuario`),
  CONSTRAINT `FKq7gb4wrm2hx3qiwh2q9vll7l2`
    FOREIGN KEY (`id_producto`)
    REFERENCES `inventario`.`productos` (`id_producto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci