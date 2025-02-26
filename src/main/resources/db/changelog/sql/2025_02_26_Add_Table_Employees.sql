--liquibase formatted sql
--changeset dcervantes:1

CREATE TABLE IF NOT EXISTS empleados (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    puesto VARCHAR(255),
    salario FLOAT(10,0),
    fecha_contratacion DATETIME(0),
    fecha_creacion DATETIME(0),
    fecha_edicion DATETIME(0)
);