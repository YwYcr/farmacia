CREATE SCHEMA farmacia ;
create user 'adminBD'@'%' identified by 'passwordBD';
grant all privileges on farmacia.* to 'adminBD'@'%';
flush privileges;
drop user adminBD;


create table farmacia.admin (
  adminid INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(20) NOT NULL,
  apellidos VARCHAR(30) NOT NULL,
  correo VARCHAR(25) NULL,
  password VARCHAR(30) NOT NULL,
  PRIMARY KEY (adminid)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;


create table farmacia.user (
  userid INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(20) NOT NULL,
  apellidos VARCHAR(30) NOT NULL,
  correo VARCHAR(25) NULL,
  password VARCHAR(30) NOT NULL,
  PRIMARY KEY (userid)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;



create table farmacia.categoria (
  categoriaid INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(20) NOT NULL,
  activo bool,
  PRIMARY KEY (categoriaid)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;




create table farmacia.items (
  itemid INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(20) NOT NULL,
  categoriaid int not null,
  precio double,
  cantidad INT,
  PRIMARY KEY (itemid),
  foreign key fk_categoriaId (categoriaid) references categoria(categoriaid)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;




create table farmacia.expediente (
  expedienteid INT NOT NULL AUTO_INCREMENT,
  cedula VARCHAR(20) NOT NULL,
  contacto VARCHAR(30) NOT NULL,
  descripcion VARCHAR(100) NULL,
  fecha date,
  activo bool,
  userid INT NOT NULL,
  PRIMARY KEY (expedienteid),
  foreign key fk_userId (userid) references user(userid)
  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;


create table farmacia.ordenes (
  ordenid INT NOT NULL AUTO_INCREMENT,
  itemid INT NOT NULL,
  cantidad INT,
  fecha date,
  activo bool,
  userid INT NOT NULL, 
  PRIMARY KEY (ordenid),
  foreign key fk_userId (userid) references user(userid),
  foreign key fk_itemId (itemid) references items(itemid)
  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;


insert into farmacia.admin (adminid,nombre,apellidos,correo,password) values
(1,"Daniel","Alvarado Vega","alvarado@gmail.com","cisco123"),
(2,"Pablo","Oconitrillo Cascante","Oconicas@gmail.com","cisco123");

insert into farmacia.user (userid,nombre,apellidos,correo,password) values
(1,"Alejandro","Fallas Mata","fallasma@gmail.com","patito123"),
(2,"Jim","Coto Cruz","cotocruz@gmail.com","patito123");

insert into farmacia.categoria (categoriaid,nombre,activo) values
(1,"Bienestar",true),
(2,"Sistema Circulatorio",true),
(3,"Sistema Digestivo",true),
(4,"Gripe o dolor",true),
(5,"Salud Sexual",true);

insert into farmacia.items(itemid,nombre,categoriaid,precio,cantidad) values
(1,"Electrolit Morado",1,2500,20),
(2,"Electrolit Rojo",1,2500,20),
(3,"Electrolit Verde",1,2500,20),
(4,"Electrolit Azul",1,2500,20),
(5,"CardioAspirina 1.5mg",2,2000,200),
(6,"CardioAspirina 2.5mg",2,2500,200),
(7,"CardioAspirina 5mg",2,5000,200),
(8,"Betaserc 16mg",2,1000,100),
(9,"Betaserc 24mg",2,2000,100),
(10,"AciTip jarabe",3,11000,100),
(11,"AciTip tabletas",3,4000,100),
(12,"PeptoBismol 118ml",3,2600,100),
(13,"PeptoBismol 228ml",3,5000,100),
(14,"BioGaia 8ml",3,13000,100),
(15,"Novagesic Dia",4,3000,100),
(16,"Novagesic noche",4,3000,100),
(17,"Gex Dia",4,1000,100),
(18,"Gex Noche",4,1000,100),
(19,"Antifludes",4,4000,100),
(20,"Adella",5,8500,100),
(21,"Angeliq",5,15000,100),
(22,"Durex Fiesta",5,4000,100),
(23,"Durex Delgado",4,4000,100),
(24,"Prudence Lubricante",4,4900,100);

insert into farmacia.expediente(expedienteid,cedula,contacto,descripcion,fecha,activo,userid) values
(1,"102550433","87898586","El paciente muestra sintomas de gripe","2022-01-05",true,1),
(2,"402110533","78797673","El paciente muestra sintomas de presion alta","2022-01-05",true,1);


insert into farmacia.ordenes(ordenid,itemid,cantidad,fecha,activo,userid) values
(1,1,1,"2022-01-05",true,1),
(2,4,2,"2022-01-05",true,2);

create table farmacia.usuario (
   id_usuario INT NOT NULL AUTO_INCREMENT,
   username varchar(20),
   password varchar (200),
primary key (id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

create table farmacia.rol (
   id_rol INT NOT NULL AUTO_INCREMENT,
   nombre varchar(20),
   id_usuario int,
   PRIMARY KEY (id_rol),
   foreign key fk_rol_usuario (id_usuario) references usuario(id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_eo_0900_ai_ci;

insert into farmacia.usuario (id_usuario, username, password) values
(1, 'Pablo', '123'),
(2, 'Daniel', '456'),
(3, 'Jose', '789');

insert into farmacia.rol(id_rol, nombre, id_usuario) values
(1, 'ROLE_ADMIN', 1),
(2, 'ROLE_VENDEDOR', 2),
(3, 'ROLE_USER', 3);



select * from farmacia.usuario;





