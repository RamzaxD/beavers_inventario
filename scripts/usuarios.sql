CREATE TABLE IF NOT EXISTS `inventario`.`usuarios` (
  `id_usuario` BIGINT NOT NULL AUTO_INCREMENT,
  `contrasena` VARCHAR(25) NOT NULL,
  `correo` VARCHAR(50) NOT NULL,
  `estatus` BIT(1) NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `id_rol` BIGINT NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `UKcdmw5hxlfj78uf4997i3qyyw5` (`correo` ASC) VISIBLE,
  INDEX `FK3kl77pehgupicftwfreqnjkll` (`id_rol` ASC) VISIBLE,
  CONSTRAINT `FK3kl77pehgupicftwfreqnjkll`
    FOREIGN KEY (`id_rol`)
    REFERENCES `inventario`.`roles` (`id_rol`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
