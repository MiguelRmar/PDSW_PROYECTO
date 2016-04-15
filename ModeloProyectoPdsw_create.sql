-- tables
-- Table: ROLES
CREATE TABLE ROLES (
    rol varchar(20) NOT NULL,
    PRIMARY KEY (rol)
);
-- Table: USUARIOS
CREATE TABLE USUARIOS (
    id int NOT NULL,
    nombre varchar(100) NOT NULL,
    correo varchar(50) NOT NULL,
    contrasena varchar(50) NOT NULL,
    PRIMARY KEY (id)
);
-- Table: ROLES_USUARIOS
CREATE TABLE ROLES_USUARIOS (
    USUARIOS_id int NOT NULL,
    ROLES_rol varchar(20) NOT NULL,
    PRIMARY KEY (USUARIOS_id,ROLES_rol),
    CONSTRAINT ROLES_USUARIOS_ROLES FOREIGN KEY (ROLES_rol) REFERENCES ROLES (rol),
    CONSTRAINT ROLES_USUARIOS_USUARIOS FOREIGN KEY (USUARIOS_id) REFERENCES USUARIOS (id)
);
-- Table: EQUIPOS
CREATE TABLE EQUIPOS (
    serial int NOT NULL,
    nombre varchar(100) NOT NULL,
    modelo int NULL,
    clase varchar(100) NOT NULL,
    vidaUtil int NOT NULL,
    valor int NOT NULL,
    seguro bool NOT NULL,
    foto blob NOT NULL,
    placa int NULL,
    marca varchar(100) NOT NULL,
    descripcion varchar(200) NOT NULL,
    -- SEVIDOR, en ves de varchar enum('activo','desactivo')
    estado varchar(50) NOT NULL,
    -- SEVIDOR, en ves de varchar enum('prestamo diario','prestamo 24 horas','mantenimiento','en almacen','prestamo indefinido','prestamo por semestre','dado de baja','en reparacion')
    subestados varchar(50) NOT NULL,
    UNIQUE INDEX placa (placa),
    PRIMARY KEY (serial)
)ENGINE=InnoDB;

-- Table: EQUIPOS_BASICOS
CREATE TABLE EQUIPOS_BASICOS (
    nombre varchar(100) NOT NULL,
    valor int NULL,
    foto int NOT NULL,
    descripcion varchar(200) NULL,
    cantidad int NOT NULL,
    PRIMARY KEY (nombre)
);
-- Table: PRESTAMOS
CREATE TABLE PRESTAMOS (
    USUARIOS_id int NOT NULL,
    EQUIPOS_serial int NOT NULL,
    fechaExpedicion date NOT NULL,
    fechaVencimiento date NULL,
    -- SEVIDOR, en ves de varchar enum('prestamo diario','prestamo 24 horas','mantenimiento','en almacen','prestamo indefinido','prestamo por semestre','dado de baja','en reparacion')
    tipoPrestamo varchar(50) NOT NULL,
    PRIMARY KEY (USUARIOS_id,EQUIPOS_serial),
    CONSTRAINT EQUIPOS_USUARIOS_EQUIPOS FOREIGN KEY (EQUIPOS_serial) REFERENCES EQUIPOS(serial),
    CONSTRAINT EQUIPOS_USUARIOS_USUARIOS FOREIGN KEY (USUARIOS_id) REFERENCES USUARIOS(id)
);
-- Table: PRESTAMOS_BASICOS
CREATE TABLE PRESTAMOS_BASICOS (
    EQUIPOS_BASICOS_nombre varchar(100) NOT NULL,
    USUARIOS_id int NOT NULL,
    fechaExpedicion date NOT NULL,
    fechaVencimiento date NOT NULL,
    tipoPrestamo varchar(20) NOT NULL,
    PRIMARY KEY (EQUIPOS_BASICOS_nombre,USUARIOS_id),
    CONSTRAINT PRESTAMOS_BASICOS_EQUIPOS_BASICOS FOREIGN KEY (EQUIPOS_BASICOS_nombre) REFERENCES EQUIPOS_BASICOS(nombre),
    CONSTRAINT PRESTAMOS_BASICOS_USUARIOS FOREIGN KEY (USUARIOS_id) REFERENCES USUARIOS (id)
);