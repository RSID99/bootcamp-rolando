CREATE TABLE USUARIOS (
	ID SERIAL PRIMARY KEY,
	USERNAME VARCHAR(100) NOT NULL,
	EMAIL VARCHAR (100) NOT NULL UNIQUE,
	ROLE VARCHAR	(100),
	CREATED_AT TIMESTAMP NOT NULL
);

CREATE TABLE POSTS (
	ID SERIAL PRIMARY KEY,
	TITULO VARCHAR(100) NOT NULL,
	MENSAJE TEXT ,
	USER_ID INT ,
	ESTADO VARCHAR(100),
	CREATED_AT TIMESTAMP NOT NULL,
	FOREIGN KEY (USER_ID) REFERENCES USUARIOS (ID)
);

CREATE TABLE COMENTARIOS (
	ID SERIAL PRIMARY KEY,
	COMENTARIO TEXT,
	USER_ID INT,
	POST_ID INT,
	ESTADO VARCHAR(100),
	CREATED_AT TIMESTAMP NOT NULL,
	FOREIGN KEY (USER_ID) REFERENCES USUARIOS (ID),
	FOREIGN KEY (POST_ID) REFERENCES POSTS (ID)
);

CREATE TABLE SEGUIDORES (
	SEGUIDOR_USER_ID INT,
	SEGUIDO_USER_ID INT,
	CREATED_AT TIMESTAMP NOT NULL,
	FOREIGN KEY (SEGUIDOR_USER_ID) REFERENCES USUARIOS(ID),
	FOREIGN KEY (SEGUIDO_USER_ID) REFERENCES USUARIOS(ID)
);

COMMENT ON COLUMN COMENTARIOS.COMENTARIO IS 'Comentario sobre un post';
COMMENT ON COLUMN POSTS.MENSAJE IS 'Cuerpo del post';


INSERT INTO USUARIOS (USERNAME,EMAIL,ROLE,CREATED_AT)
VALUES ('JUANA', 'JUANA@GMAIL.COM','ADMINISTRADOR', CURRENT_TIMESTAMP),
	   ('RAUL', 'RAUL@GMAIL.ES', 'EDITOR',CURRENT_TIMESTAMP);
INSERT INTO POSTS (TITULO,MENSAJE,USER_ID,ESTADO,CREATED_AT)
VALUES ('PROBANDO','CORRECTO',3,'ACTIVO',CURRENT_TIMESTAMP),
	   ('PROGRAMADOR','HACER COMMIT',4,'ACTIVO',CURRENT_TIMESTAMP);
INSERT INTO COMENTARIOS (COMENTARIO,USER_ID,POST_ID,ESTADO,CREATED_AT)
VALUES ('CODIGO CORRECTO',3,1,'BORRADOR',CURRENT_TIMESTAMP),
	   ('GUARDAR CODIGO',4,2,'ENVIADO',CURRENT_TIMESTAMP);
INSERT INTO SEGUIDORES (SEGUIDOR_USER_ID,SEGUIDO_USER_ID,CREATED_AT)
VALUES (3,4,CURRENT_TIMESTAMP),
	   (4,3,CURRENT_TIMESTAMP);
	   
INSERT INTO USUARIOS(USERNAME, EMAIL, ROLE, CREATED_AT)
VALUES ('ROLANDO','ROLANDO@GMAIL.COM', 'USUARIO', CURRENT_TIMESTAMP),
	   ('ROBERTO', 'RO@GMAIL.COM', 'USUARIO', CURRENT_TIMESTAMP);
	   
--ELIMINA UN USUARIO CON ID 14
DELETE FROM USUARIOS WHERE ID = 14;
--AGREGA UNA COLUMNA A LA TABLA
ALTER TABLE USUARIOS ADD COLUMN TELEFONO VARCHAR(50);
---MODIFICA LOS DATOS DE LA COLUMNA
UPDATE USUARIOS
SET TELEFONO = '0981000000'
WHERE ID = 3;

UPDATE USUARIOS
SET TELEFONO = '0981000001'
WHERE ID = 4;

UPDATE USUARIOS 
SET TELEFONO = '0981000002'
WHERE ID = 13;

UPDATE USUARIOS
SET EMAIL = 'ROL@GMAIL.COM'
WHERE ID = 13;