CREATE TABLE `test`.`rol` (
  `id_rol` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `id_usuario` INT NULL,
  PRIMARY KEY (`id_rol`),
  INDEX `id_rol_usuario_idx` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `id_rol_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `test`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);