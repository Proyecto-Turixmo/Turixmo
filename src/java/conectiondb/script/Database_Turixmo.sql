DROP DATABASE IF EXISTS proyecto_turixmo;

CREATE DATABASE proyecto_turixmo;
USE proyecto_turixmo;
CREATE TABLE paises(
idpais INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(100)  NOT NULL,
primary key(idpais)
);

CREATE TABLE departamentos(
iddepartamento INT NOT NULL AUTO_INCREMENT,
idpais INT NOT NULL,
nombre VARCHAR(100)  NOT NULL,
primary key(iddepartamento),
foreign key (idpais) references paises(idpais)
);

CREATE TABLE ciudades(
idciudad INT NOT NULL AUTO_INCREMENT,
iddepartamento INT NOT NULL,
nombre VARCHAR(100)  NOT NULL,
primary key(idciudad),
foreign key (iddepartamento) references departamentos(iddepartamento)
);

CREATE TABLE tiposdocumento(
idtipodocumento INT NOT NULL AUTO_INCREMENT,
nombre varchar(50)  NOT NULL,
primary key(idtipodocumento)
);

CREATE TABLE tiposhabitacion(
idtipohabitacion INT NOT NULL AUTO_INCREMENT,
tipohabitacion varchar(50)  NOT NULL,
descripcion varchar(300) NULL,
primary key(idtipohabitacion)
);

CREATE TABLE roles(
idrol INT NOT NULL AUTO_INCREMENT,
tiporol varchar(50)  NOT NULL,
primary key(idrol)
);

CREATE TABLE usuarios(
idusuario INT NOT NULL AUTO_INCREMENT,
idtipodocumento INT  NOT NULL,
numerodocumento VARCHAR(100)  NOT NULL UNIQUE,
idrol INT  NOT NULL,
nombre VARCHAR(100)  NOT NULL,
apellido VARCHAR(100)  NOT NULL,
correo VARCHAR(100)  NOT NULL UNIQUE,
contrasena VARCHAR(100)  NOT NULL,
celular VARCHAR(100)  NOT NULL UNIQUE,
token VARCHAR(100) NULL,
imagen VARCHAR(100) NULL,
fechanacimiento DATE NULL,
fechacreacion DATETIME  NOT NULL,
primary key(idusuario),
foreign key (idtipodocumento) references tiposdocumento (idtipodocumento),
foreign key (idrol) references roles (idrol)
);

CREATE TABLE servicioshabitacion(
idserviciohabitacion  INT NOT NULL AUTO_INCREMENT,
camadoble BOOLEAN NOT NULL,
aireacondicionado BOOLEAN NOT NULL,
wifi BOOLEAN NOT NULL,
cafetera BOOLEAN NOT NULL,
cajafuerte BOOLEAN NOT NULL,
vistaexterior BOOLEAN NOT NULL,
mascota BOOLEAN NOT NULL,
tinabano BOOLEAN NOT NULL,
television BOOLEAN NOT NULL,
comida BOOLEAN NOT NULL,
telefono BOOLEAN NOT NULL,
primary key(idserviciohabitacion)
);

CREATE TABLE hoteles(
idhotel INT NOT NULL AUTO_INCREMENT,
idusuario INT NOT NULL , 
idciudad INT NULL,
nombre VARCHAR(100) NOT NULL,
direccion VARCHAR(100) NOT NULL,
ubicacion VARCHAR(100) NULL,
telefono VARCHAR(100) NULL,
celular VARCHAR(100) NOT NULL,
correo VARCHAR(100) NOT NULL,
sitioweb VARCHAR(100) NULL,
descripcion MEDIUMTEXT NULL,
fechacreacion DATETIME NOT NULL,
primary key (idhotel),
foreign key (idusuario) references usuarios (idusuario),
foreign key (idciudad) references ciudades (idciudad)
);

CREATE TABLE habitaciones(
idhabitacion INT NOT NULL AUTO_INCREMENT,
idtipohabitacion INT NOT NULL , 
idserviciohabitacion INT NOT NULL ,
idhotel INT NOT NULL , 
numerohabitacion VARCHAR(50) NOT NULL,
cantidadpersonas INT NOT NULL,
precio INT  NOT NULL,
numeropiso VARCHAR(50) NULL,
descripcion mediumtext NULL,
disponibilidad BOOLEAN NOT NULL,
fechacreacion DATETIME NOT NULL,
primary key (idhabitacion),
foreign key (idtipohabitacion) references tiposhabitacion (idtipohabitacion),
foreign key (idserviciohabitacion) references servicioshabitacion (idserviciohabitacion),
foreign key (idhotel) references hoteles (idhotel)
);

CREATE TABLE reservas(
idreserva  INT NOT NULL AUTO_INCREMENT,
idhabitacion INT NOT NULL,
idusuario INT NOT NULL, 
precio INT NOT NULL,
descripcion MEDIUMTEXT NOT NULL,
fechaentrada DATETIME  NOT NULL,
fechasalida DATETIME  NOT NULL,
fechareserva DATETIME  NOT NULL,
primary key(idreserva),
foreign key (idhabitacion) references habitaciones (idhabitacion),
foreign key (idusuario) references usuarios (idusuario)
);

-- insercion de datos basicos
-- roles o actores del sistema
INSERT INTO roles VALUES (null,"Administrador"),(null,"Propietario"),(null,"Turista");

INSERT INTO tiposdocumento VALUES (null,"Cédula de ciudadania"),
								  (null,"Cédula de extranjeria");

INSERT INTO paises VALUES (null,"Colombia");

INSERT INTO departamentos VALUES(1,1,"Amazonas"),(2,1,"Antioquia"),(3,1,"Arauca"),(4,1,"Atlántico"),
								(5,1,"Bolívar"),(6,1,"Boyacá"),(7,1,"Caldas"),(8,1,"Caquetá"),
                                (9,1,"Casanare"),(10,1,"Cauca"),(11,1,"Cesar"),(12,1,"Chocó"),
                                (13,1,"Córdoba"),(14,1,"Cundinamarca"),(15,1,"Guainía"),(16,1,"Guaviare"),
                                (17,1,"Huila"),(18,1,"La Guajira"),(19,1,"Magdalena"),(20,1,"Meta"),
                                (21,1,"Nariño"),(22,1,"Norte de Santander"),(23,1,"Putumayo"),(24,1,"Quindío"),
                                (25,1,"Risaralda"),(26,1,"San Andrés y Providencia"),(27,1,"Santander"),(28,1,"Sucre"),
							    (29,1,"Tolima"),(30,1,"Valle del Cauca"),(31,1,"Vaupés"),(32,1,"Vichada");
                                
INSERT INTO ciudades VALUES (1,1,"Leticia"),(2,2,"Medellin"),(3,3,"Arauca"),(4,4,"Barranquilla"),
							(5,5,"Cartagena"),(6,6,"Tunja"),(7,7,"Manizales"),(8,8,"Florencia"),
							(9,9,"Yopal"),(10,10,"Popayán"),(11,11,"Valledupar"),(12,12,"Quibdó"),
							(13,13,"Montería"),(14,14,"Bogotá D.C"),(15,15,"Inírida"),(16,16,"San Jose del Guaviare"),
							(17,17,"Neiva"),(18,18,"Riohacha"),(19,19,"Santa Marta"),(20,20,"Villavicencio"),
							(33,20,"Acacias"),(34,20,"Guamal"),(35,20,"Granada"),(36,20,"San Martín"),
							(21,21,"Pasto"),(22,22,"Cúcuta"),(23,23,"Mocoa"),(24,24,"Armenia"),
							(25,25,"Pereira"),(26,26,"San Andrés"),(27,27,"Bucaramanga"),(28,28,"Sincelejo"),
							(29,29,"Ibagué"),(30,30,"Cali"),(31,31,"Mitú"),(32,32,"Puerto Carreño");

INSERT INTO tiposhabitacion VALUES 	(null,"Individual Sencilla","Una habitación asignada a una persona. Solo tiene una cama."),
									(null,"Individual","Una habitación asignada a una persona. Puede tener una o más camas."),
									(null,"Doble"," Una habitación asignada a dos personas. Puede tener una o más camas."),
                                    (null,"Triple","Una habitación asignada a tres personas. Puede tener dos o más camas."),
                                    (null,"Quad","Una sala asignada a cuatro personas. Puede tener dos o más camas."),
                                    (null,"Queen","Una habitación con una cama de matrimonio. Puede ser ocupado por una o más personas."),
                                    (null,"King","Una habitación con una cama king-size. Puede ser ocupado por una o más personas"),
                                    (null,"Quad","Una habitación con dos camas. Puede ser ocupado por una o más personas."),
                                    (null,"Estudio","una habitación con una cama de estudio, un sofá que se puede convertir en una cama. También puede tener una cama adicional.");