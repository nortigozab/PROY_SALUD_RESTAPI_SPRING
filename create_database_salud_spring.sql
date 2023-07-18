-- Creación de la base de datos

CREATE DATABASE salud_spring;

USE salud_spring;


-- Tabla especialidades

CREATE TABLE
    especialidades (
        id_especialidad INT PRIMARY KEY AUTO_INCREMENT,
        nombre_especialidad VARCHAR(50) NOT NULL
    );

-- Tabla pacientes

CREATE TABLE
    pacientes (
        id_paciente INT PRIMARY KEY AUTO_INCREMENT,
        nombre VARCHAR(50) NOT NULL,
        numero_cedula VARCHAR(10) NOT NULL UNIQUE,
        apellido VARCHAR(50) NOT NULL,
        fecha_nacimiento DATE NOT NULL,
        telefono VARCHAR(50) NOT NULL
    );

-- Tabla doctores

CREATE TABLE
    doctores (
        id_doctor INT PRIMARY KEY AUTO_INCREMENT,
        nombre VARCHAR(50) NOT NULL,
        apellido VARCHAR(50) NOT NULL,
        especialidad INT NOT NULL,
        consultorio INT NOT NULL,
        correo_contacto VARCHAR(50) NOT NULL,
        FOREIGN KEY (especialidad) REFERENCES especialidades(id_especialidad) ON DELETE CASCADE
    );

-- Tabla citas_medicas

CREATE TABLE
    citas_medicas (
        id_cita INT PRIMARY KEY AUTO_INCREMENT,
        id_doctor INT NOT NULL,
        id_paciente INT,
        especialidad INT NOT NULL,
        fecha DATE NOT NULL,
        disponibilidad BOOLEAN NOT NULL,
        FOREIGN KEY (id_doctor) REFERENCES doctores(id_doctor) ON DELETE CASCADE,
        FOREIGN KEY (id_paciente) REFERENCES pacientes(id_paciente) ON DELETE CASCADE,
        FOREIGN KEY (especialidad) REFERENCES especialidades(id_especialidad) ON DELETE CASCADE
    );


INSERT INTO especialidades (nombre_especialidad) VALUES
    ('Medicina general'),
    ('Cardiología'),
    ('Medicina interna'),
    ('Dermatología'),
    ('Rehabilitación física'),
    ('Psicología'),
    ('Odontología'),
    ('Radiología');

INSERT INTO pacientes (nombre, numero_cedula, apellido, fecha_nacimiento, telefono) VALUES
    ('Juan', '123456789', 'Pérez', '1990-01-15', '1234567890'),
    ('María', '987654321', 'Gómez', '1995-06-20', '9876543210'),
    ('Carlos', '456789123', 'López', '1980-09-10', '4567891230'),
    ('Laura', '789123456', 'Martínez', '1985-03-25', '7891234560'),
    ('Pedro', '654321987', 'Sánchez', '1970-12-03', '6543219870'),
    ('Ana', '321987654', 'Ramírez', '1993-07-08', '3219876540'),
    ('José', '896745231', 'Hernández', '1988-11-12', '8967452310'),
    ('Sofía', '234567891', 'Torres', '1979-04-18', '2345678910'),
    ('Luis', '678912345', 'García', '1984-08-30', '6789123450'),
    ('Isabel', '987123456', 'Rodríguez', '1992-02-05', '9871234560');

-- Doctores de Medicina General
INSERT INTO doctores (nombre, apellido, especialidad, consultorio, correo_contacto) VALUES
    ('Juan', 'López', 1, 101, 'julo1@example.com'),
    ('María', 'González', 1, 102, 'mago1@example.com');

-- Doctores de Cardiología
INSERT INTO doctores (nombre, apellido, especialidad, consultorio, correo_contacto) VALUES
    ('Pedro', 'Sánchez', 2, 103, 'pesa1@example.com'),
    ('Ana', 'Ramírez', 2, 104, 'anra1@example.com');

-- Doctores de Medicina Interna
INSERT INTO doctores (nombre, apellido, especialidad, consultorio, correo_contacto) VALUES
    ('Carlos', 'Martínez', 3, 105, 'cama1@example.com'),
    ('Laura', 'Hernández', 3, 106, 'laher1@example.com');

-- Doctores de Dermatología
INSERT INTO doctores (nombre, apellido, especialidad, consultorio, correo_contacto) VALUES
    ('Sofía', 'Torres', 4, 107, 'soto1@example.com'),
    ('Luis', 'García', 4, 108, 'luga1@example.com');

-- Doctores de Rehabilitación Física
INSERT INTO doctores (nombre, apellido, especialidad, consultorio, correo_contacto) VALUES
    ('Marcela', 'Pérez', 5, 109, 'mape1@example.com'),
    ('Andrés', 'Gómez', 5, 110, 'ango1@example.com');

-- Doctores de Psicología
INSERT INTO doctores (nombre, apellido, especialidad, consultorio, correo_contacto) VALUES
    ('Valeria', 'Navarro', 6, 111, 'vane1@example.com'),
    ('Hugo', 'Fernández', 6, 112, 'hufer1@example.com');

-- Doctores de Odontología
INSERT INTO doctores (nombre, apellido, especialidad, consultorio, correo_contacto) VALUES
    ('Isabella', 'Luna', 7, 201, 'islu1@example.com'),
    ('Emilio', 'Rojas', 7, 202, 'emro1@example.com');

-- Doctores de Radiología
INSERT INTO doctores (nombre, apellido, especialidad, consultorio, correo_contacto) VALUES
    ('Camila', 'Silva', 8, 203, 'casi1@example.com'),
    ('Alejandro', 'Mendoza', 8, 204, 'alem1@example.com');


-- Citas médicas disponibles
INSERT INTO citas_medicas (id_doctor, especialidad, fecha, disponibilidad)
VALUES (1, 1, '2023-07-01', true),
       (2, 1, '2023-07-02', true),
       (3, 2, '2023-07-03', true),
       (4, 2, '2023-07-04', true),
       (5, 3, '2023-07-05', true),
       (6, 3, '2023-07-06', true),
       (7, 4, '2023-07-07', true),
       (8, 4, '2023-07-08', true),
       (9, 5, '2023-07-09', true),
       (10, 5, '2023-07-10', true);

-- Citas médicas no disponibles
INSERT INTO citas_medicas (id_doctor, id_paciente, especialidad, fecha, disponibilidad)
VALUES (11, 1, 6, '2023-07-11', false),
       (12, 2, 6, '2023-07-12', false),
       (13, 3, 7, '2023-07-13', false),
       (14, 4, 7, '2023-07-14', false),
       (15, 5, 8, '2023-07-15', false),
       (16, 6, 8, '2023-07-16', false);





