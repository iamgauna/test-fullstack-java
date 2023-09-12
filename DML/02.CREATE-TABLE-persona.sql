CREATE TABLE `test`.`persona` (
  `id_persona` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `contrasena` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  `saldo` DOUBLE NULL,
  PRIMARY KEY (`id_persona`));