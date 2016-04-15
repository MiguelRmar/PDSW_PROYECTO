-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2016-04-14 20:56:37.248

-- tables
-- Table: EQUIPOS
CREATE TABLE EQUIPOS (
    serial int NOT NULL,
    nombre varchar(100) NOT NULL,
    modelo varchar(100) NOT NULL,
    clase varchar(100) NOT NULL,
    vidaUtil int NOT NULL,
    valor int NOT NULL,
    seguro bool NOT NULL,
    foto blob NOT NULL,
    estado varchar(20) NOT NULL,
    placa int NULL,
    tiempoPrestamo int NOT NULL,
    CONSTRAINT codigo PRIMARY KEY (serial)
)ENGINE=InnoDB;

-- Table: EQUIPOS_BASICOS
CREATE TABLE EQUIPOS_BASICOS (
    nombre varchar(100) NOT NULL,
    cantidadTotal int NOT NULL,
    cantidadPrestado int NOT NULL,
    USUARIOS_id int NOT NULL,
    CONSTRAINT EQUIPOS_BASICOS_pk PRIMARY KEY (nombre)
)ENGINE=InnoDB;

-- Table: PRESTAMOS
CREATE TABLE PRESTAMOS (
    USUARIOS_id int NOT NULL,
    EQUIPOS_serial int NOT NULL,
    fechaSalida date NOT NULL,
    fechaEntrega date NULL,
    tipoEstado varchar(20) NOT NULL,
    CONSTRAINT PRESTAMOS_pk PRIMARY KEY (USUARIOS_id,EQUIPOS_serial)
)ENGINE=InnoDB;

-- Table: USUARIOS
CREATE TABLE USUARIOS (
    id int NOT NULL,
    nombre varchar(100) NOT NULL,
    tipo varchar(15) NOT NULL,
    CONSTRAINT USUARIOS_pk PRIMARY KEY (id)
)ENGINE=InnoDB;

-- foreign keys
-- Reference: EQUIPOS_BASICOS_USUARIOS (table: EQUIPOS_BASICOS)
ALTER TABLE EQUIPOS_BASICOS ADD CONSTRAINT EQUIPOS_BASICOS_USUARIOS FOREIGN KEY EQUIPOS_BASICOS_USUARIOS (USUARIOS_id)
    REFERENCES USUARIOS (id);

-- Reference: EQUIPOS_USUARIOS_EQUIPOS (table: PRESTAMOS)
ALTER TABLE PRESTAMOS ADD CONSTRAINT EQUIPOS_USUARIOS_EQUIPOS FOREIGN KEY EQUIPOS_USUARIOS_EQUIPOS (EQUIPOS_serial)
    REFERENCES EQUIPOS (serial);

-- Reference: EQUIPOS_USUARIOS_USUARIOS (table: PRESTAMOS)
ALTER TABLE PRESTAMOS ADD CONSTRAINT EQUIPOS_USUARIOS_USUARIOS FOREIGN KEY EQUIPOS_USUARIOS_USUARIOS (USUARIOS_id)
    REFERENCES USUARIOS (id);

-- End of file.

